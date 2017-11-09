package com.hongfeng.greenhouses.service.user.inf;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.user.dto.UserInfoDTO;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Jiazefeng on 2017/10/20.
 */
public interface UserService {
    /**
     * 根据参数获取用户信息
     *
     * @param request
     * @param response @return
     * @param model
     */
    String getUserInfoByParameter(HttpServletRequest request, HttpServletResponse response, Model model);

    /**
     * 分页获取用户信息列表
     *
     * @param userInfoDTO
     * @param webPage
     * @return
     */
    List<UserInfoDTO> getUserInfoList(UserInfoDTO userInfoDTO, WebPage webPage);

    /**
     * @param userInfoDTO
     * @return
     */
    String addUserInfo(UserInfoDTO userInfoDTO);

    /**
     * 根据userId获取用户信息
     *
     * @param userId
     */
    UserInfoDTO getUserInfoById(String userId);

    /**
     * 编辑用户信息
     *
     * @param userInfoDTO
     */
    void editUserInfo(UserInfoDTO userInfoDTO);

    /**
     * 删除用户信息
     * @param userId
     */
    void deleteUserInfo(String userId);
}
