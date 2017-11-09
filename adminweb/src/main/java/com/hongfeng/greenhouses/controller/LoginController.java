package com.hongfeng.greenhouses.controller;

import com.hongfeng.common.tool.IdGen;
import com.hongfeng.common.tool.PasswordEncode;
import com.hongfeng.greenhouses.domain.user.model.UserInfoEntity;
import com.hongfeng.greenhouses.domain.user.model.UserLoginBook;
import com.hongfeng.greenhouses.service.user.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Jiazefeng on 2017/10/16.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/loginCheck.html", method = RequestMethod.POST)
    public String  loginCheck(Model model, HttpServletRequest request, HttpServletResponse response) {
//        return "/main/main";
        return userService.getUserInfoByParameter(request,response,model);
    }
}
