package com.hongfeng.greenhouses.service.menu.impl;

import com.hongfeng.common.tool.IdGen;
import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.menu.dto.MenuInfoDTO;
import com.hongfeng.greenhouses.domain.menu.model.MenuModel;
import com.hongfeng.greenhouses.domain.menu.repository.MenuRepository;
import com.hongfeng.greenhouses.service.menu.inf.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Jiazefeng on 2017/10/18.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public void addFirstMenu(MenuInfoDTO menuInfoDTO) {

        MenuModel newMenu = new MenuModel();
        newMenu.setMenuId(IdGen.uuid());//菜单ID
        newMenu.setMenuName(menuInfoDTO.getMenuName());//菜单名称
        newMenu.setChildFlag(0);//是否有子菜单
        newMenu.setMenuDescription(menuInfoDTO.getMenuDesc());//菜单描述
        newMenu.setMenuState(1);//菜单状态
        newMenu.setMenuLevel(1);//菜单级别
        newMenu.setMenuOrder(Integer.parseInt(menuInfoDTO.getMenuOrder()));//菜单排序
        newMenu.setOwner("property");//所属系统
        newMenu.setCreateOn(new Date());
        newMenu.setModifyOn(new Date());
        menuRepository.addMenuModel(newMenu);
    }

    @Override
    public List<MenuInfoDTO> getMenuInfoList(MenuInfoDTO menuInfoDTO, WebPage webPage) {
        Map map = new HashMap();
        List<MenuModel> menuModelList = menuRepository.getMenuEntityList(map, webPage);
        List<MenuInfoDTO> menuInfoDTOList = new ArrayList<MenuInfoDTO>();
        if (menuModelList != null && menuModelList.size() > 0) {
            for (MenuModel menuModel : menuModelList) {
                MenuInfoDTO menuInfoDTO1 = new MenuInfoDTO();
                menuInfoDTO1.setMenuId(menuModel.getMenuId());//菜单ID
                menuInfoDTO1.setMenuName(menuModel.getMenuName());//菜单名称
                menuInfoDTO1.setMenuLevel(menuModel.getMenuLevel() + "");//菜单级别
                menuInfoDTO1.setMenuDesc(menuModel.getMenuDescription());//菜单描述
                menuInfoDTO1.setMenuUrl(menuModel.getMenuUrl());//菜单URL
                menuInfoDTOList.add(menuInfoDTO1);
            }
        }
        return menuInfoDTOList;
    }
}
