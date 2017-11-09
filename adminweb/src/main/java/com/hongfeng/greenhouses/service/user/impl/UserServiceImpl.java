package com.hongfeng.greenhouses.service.user.impl;

import com.hongfeng.common.tool.*;
import com.hongfeng.greenhouses.domain.user.dto.UserInfoDTO;
import com.hongfeng.greenhouses.domain.user.model.UserInfoEntity;
import com.hongfeng.greenhouses.domain.user.model.UserLoginBook;
import com.hongfeng.greenhouses.domain.user.model.UserLoginLogEntity;
import com.hongfeng.greenhouses.domain.user.repository.UserLoginBookRepository;
import com.hongfeng.greenhouses.domain.user.repository.UserLoginLogRepository;
import com.hongfeng.greenhouses.domain.user.repository.UserRepository;
import com.hongfeng.greenhouses.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2017/10/20.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserLoginBookRepository userLoginBookRepository;
    @Autowired
    private UserLoginLogRepository userLoginLogRepository;

    @Override
    public String getUserInfoByParameter(HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
//            ModelAndView modelAndView = null;
            String userName = request.getParameter("userName");
            String old_pwd = request.getParameter("password");
            String pwd = PasswordEncode.digestPassword(old_pwd);

            UserInfoEntity userInfoEntity = new UserInfoEntity();
            userInfoEntity.setUserName(userName);
            userInfoEntity.setPassword(pwd);
            userInfoEntity.setUserState(1);

            UserInfoEntity userInfoEntity1 = userRepository.getUserInfoByParameter(userInfoEntity);
            if (userInfoEntity1 != null) {

                UserLoginBook userLoginBook = new UserLoginBook();
                userLoginBook.setTokenId(IdGen.uuid());
                userLoginBook.setUserId(userInfoEntity1.getUserId());
                userLoginBook.setLoginType("1");
                userLoginBook.setMakeDate(new Date(System.currentTimeMillis()));
                userLoginBook.setMakeTime(new Time(System.currentTimeMillis()));
                boolean f = userLoginBookRepository.addUserLoginBook(userLoginBook);

                Cookie cookie = new Cookie("vestaToken", userLoginBook.getTokenId());
                cookie.setPath("/");
                cookie.setDomain(request.getServerName());
                cookie.setMaxAge(3600 * 24 * 30);
                response.addCookie(cookie);
                response.setHeader("P3P", "CP='CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR'");

                UserLoginLogEntity userLoginLogEntity = new UserLoginLogEntity();
                userLoginLogEntity.setLogId(IdGen.uuid());
                userLoginLogEntity.setUserName(userInfoEntity1.getUserName());
                userLoginLogEntity.setUserMobile(userInfoEntity1.getUserPhone());
                userLoginLogEntity.setStaffName(userInfoEntity1.getUserRealName());
                userLoginLogEntity.setIpAddress(IpUtils.getIpAddress(request));//ip地址
                String content = userLoginLogEntity.getUserName() + "在" + DateUtils.format(new java.util.Date()) + "登录成功";
                userLoginLogEntity.setSysContent(content);//登录内容
                userLoginLogRepository.addUserLoginLog(userLoginLogEntity);
                model.addAttribute("userInfo", userInfoEntity1);
                return "/main/main";
            }
            model.addAttribute("errormsg", "用户名或密码错误");
            return "/errors/500";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserInfoDTO> getUserInfoList(UserInfoDTO userInfoDTO, WebPage webPage) {
        try {
            Map map = new HashMap();
            map.put("userName",userInfoDTO.getUserName());
            map.put("userRealName",userInfoDTO.getUserRealName());
            List<UserInfoEntity> userInfoEntityList = userRepository.getUserInfoList(map, webPage);
            List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();
            if (userInfoEntityList != null && userInfoEntityList.size() > 0) {
                for (UserInfoEntity userInfoEntity : userInfoEntityList) {
                    UserInfoDTO userInfoDTO1 = new UserInfoDTO();
                    userInfoDTO1.setUserId(userInfoEntity.getUserId());
                    userInfoDTO1.setUserName(userInfoEntity.getUserName());
                    userInfoDTO1.setUserPhone(userInfoEntity.getUserPhone());
                    userInfoDTO1.setUserRealName(userInfoEntity.getUserRealName());
                    userInfoDTO1.setUserEmail(userInfoEntity.getUserEmail());
                    userInfoDTO1.setUserBirthday(DateUtils.format(userInfoEntity.getUserBirthday(), DateUtils.FORMAT_LONG));
                    userInfoDTO1.setUserSex(userInfoEntity.getUserSex());
                    userInfoDTOList.add(userInfoDTO1);
                }
            }
            return userInfoDTOList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String addUserInfo(UserInfoDTO userInfoDTO) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserId(IdGen.uuid());
        userInfoEntity.setUserName(userInfoDTO.getUserName());
        userInfoEntity.setUserRealName(userInfoDTO.getUserRealName());
//        userInfoEntity.setUserBirthday(userInfoDTO.getUserBirthday()==null?new java.util.Date():DateUtils.parse(userInfoDTO.getUserBirthday(),DateUtils.FORMAT_LONG));
        userInfoEntity.setUserPhone(userInfoDTO.getUserPhone());
        userInfoEntity.setUserRemark(userInfoDTO.getUserRemark());
        userInfoEntity.setUserSex(userInfoDTO.getUserSex());
        userInfoEntity.setPassword(PasswordEncode.digestPassword("123456"));
        userInfoEntity.setUserState(1);
        userInfoEntity.setUserEmail(userInfoDTO.getUserEmail());
        userRepository.addUserInfo(userInfoEntity);
        return "ok";
    }

    @Override
    public UserInfoDTO getUserInfoById(String userId) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        if (!StringUtil.isEmpty(userId)) {
            UserInfoEntity userInfoEntity = userRepository.getUserInfoById(userId);
            if (userInfoEntity != null) {
                userInfoDTO.setUserId(userInfoEntity.getUserId());
                userInfoDTO.setUserName(userInfoEntity.getUserName());
                userInfoDTO.setUserRealName(userInfoEntity.getUserRealName());
                userInfoDTO.setUserPhone(userInfoEntity.getUserPhone());
                userInfoDTO.setUserSex(userInfoEntity.getUserSex());
                userInfoDTO.setUserBirthday(DateUtils.format(userInfoEntity.getUserBirthday()));
                userInfoDTO.setUserEmail(userInfoEntity.getUserEmail());
            }
        }
        return userInfoDTO;
    }

    @Override
    public void editUserInfo(UserInfoDTO userInfoDTO) {
        if (userInfoDTO != null && !StringUtil.isEmpty(userInfoDTO.getUserId())) {
            UserInfoEntity userInfoEntity = userRepository.getUserInfoById(userInfoDTO.getUserId());
            if (userInfoEntity != null) {
                userInfoEntity.setUserName(userInfoDTO.getUserName());
                userInfoEntity.setUserRealName(userInfoDTO.getUserRealName());
                userInfoEntity.setUserPhone(userInfoDTO.getUserPhone());
                userInfoEntity.setUserRemark(userInfoDTO.getUserRemark());
                userInfoEntity.setUserSex(userInfoDTO.getUserSex());
                userInfoEntity.setUserEmail(userInfoDTO.getUserEmail());
                userRepository.editUserInfo(userInfoEntity);
            }
        }
    }

    @Override
    public void deleteUserInfo(String userId) {
        if (!StringUtil.isEmpty(userId)) {
            UserInfoEntity userInfoEntity = userRepository.getUserInfoById(userId);
            if (userInfoEntity != null) {
                userInfoEntity.setUserState(0);
                userRepository.editUserInfo(userInfoEntity);
            }
        }
    }
}
