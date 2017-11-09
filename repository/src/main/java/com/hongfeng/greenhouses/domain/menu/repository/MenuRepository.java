package com.hongfeng.greenhouses.domain.menu.repository;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.menu.model.MenuModel;

import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2017/10/18.
 */
public interface MenuRepository {
    /**
     * 新增菜单
     *
     * @param newMenu
     */
    boolean addMenuModel(MenuModel newMenu);

    /**
     * 获取菜单列表
     *
     * @param map
     * @param webPage
     * @return
     */
    List<MenuModel> getMenuEntityList(Map map, WebPage webPage);
}
