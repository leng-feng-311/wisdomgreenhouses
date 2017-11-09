package com.hongfeng.greenhouses.controller;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.menu.dto.MenuInfoDTO;
import com.hongfeng.greenhouses.service.menu.inf.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Jiazefeng on 2017/10/17.
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 初始化一级菜单列表
     *
     * @return
     */
    @RequestMapping(value = "/menuManage.html", method = RequestMethod.GET)
    public String menuManage(@Valid MenuInfoDTO menuInfoDTO, Model model, WebPage webPage) {
        List<MenuInfoDTO> menuInfoDTOList = menuService.getMenuInfoList(menuInfoDTO, webPage);
        model.addAttribute("menuInfoList", menuInfoDTOList);
        model.addAttribute("menuInfo", menuInfoDTO);
        return "/menu/MenuManage";
    }

    /**
     * 添加一级菜单
     *
     * @param menuInfoDTO
     * @param
     * @return
     */
    @RequestMapping(value = "/addFirMenu", method = RequestMethod.GET)
    public ModelAndView addFirstMenu(@Valid MenuInfoDTO menuInfoDTO) {
        menuService.addFirstMenu(menuInfoDTO);
        return new ModelAndView("redirect:../menu/menuManage.html");
    }
}
