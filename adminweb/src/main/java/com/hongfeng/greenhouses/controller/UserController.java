package com.hongfeng.greenhouses.controller;

import com.hongfeng.common.result.ApiResult;
import com.hongfeng.common.result.SuccessApiResult;
import com.hongfeng.common.tool.StringUtil;
import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.user.dto.UserInfoDTO;
import com.hongfeng.greenhouses.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Jiazefeng on 2017/10/20.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户列表信息
     *
     * @param model
     * @param userInfoDTO
     * @param webPage
     * @return
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public String getUserInfo(Model model, @Valid UserInfoDTO userInfoDTO, WebPage webPage) {
        List<UserInfoDTO> userInfoDTOList = userService.getUserInfoList(userInfoDTO, webPage);
        model.addAttribute("userInfoList", userInfoDTOList);
        model.addAttribute("userInfo", userInfoDTO);
        return "/user/UserManage";
    }

    /**
     * 新增、编辑用户信息
     *
     * @param userInfoDTO
     * @return
     */
    @RequestMapping(value = "/addUserInfo", method = RequestMethod.GET)
    public String addUserInfo(@Valid UserInfoDTO userInfoDTO) {
        if(!StringUtil.isEmpty(userInfoDTO.getUserId())){
            userService.editUserInfo(userInfoDTO);
        }else {
            userService.addUserInfo(userInfoDTO);
        }
        return "redirect:../user/getUserInfo";
    }

    /**
     * 根据ID显示信息
     *
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "/getUserInfoById", method = RequestMethod.GET)
    @ResponseBody
    public ApiResult getUserInfoById(@RequestParam String userId, Model model) {
        UserInfoDTO userInfoDTO = userService.getUserInfoById(userId);
        return new SuccessApiResult(userInfoDTO);
    }

    /**
     * 删除用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteUserInfo", method = RequestMethod.GET)
    public String editUserInfo(@RequestParam String userId) {
        userService.deleteUserInfo(userId);
        return "redirect:../user/getUserInfo";
    }
}
