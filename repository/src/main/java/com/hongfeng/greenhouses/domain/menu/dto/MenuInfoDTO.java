package com.hongfeng.greenhouses.domain.menu.dto;

/**
 * Created by Jiazefeng on 2017/10/18.
 */
public class MenuInfoDTO {
    private String menuId;      //菜单id
    private String menuName;        //菜单名称
    private String menuFlag;        //是否能点，Y，N
    private String menuDesc;        //菜单描述
    private String menuState;       //菜单状态
    private String menuLevel;       //菜单级别
    private String menuOrder;       //菜单排序
    private String menuOperator;        //菜单操作人
    private String menuParentId;           //菜单父层id
    private String menuUrl;         //跳转网页

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuFlag() {
        return menuFlag;
    }

    public void setMenuFlag(String menuFlag) {
        this.menuFlag = menuFlag;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuState() {
        return menuState;
    }

    public void setMenuState(String menuState) {
        this.menuState = menuState;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getMenuOperator() {
        return menuOperator;
    }

    public void setMenuOperator(String menuOperator) {
        this.menuOperator = menuOperator;
    }

    public String getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(String menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
