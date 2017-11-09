package com.hongfeng.greenhouses.domain.menu.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;

import javax.persistence.*;

/**
 * 导航菜单信息
 * Created by Jiazefeng on 2017/10/13.
 */
@Entity
@Table(name = "MENU_INFO")
public class MenuModel extends BaseVo {
    private String menuId;//菜单ID
    private String menuName;//菜单名称
    private String menuDescription;//菜单描述
    private int menuState;  // 菜单状态 1 可用  0 不可用
    private String menuUrl;  //菜单路径
    private int menuLevel;  //菜单级别
    private String parentMenuId;  //父级菜单ID
    private int childFlag;   //是否有子菜单  1 是  0 否
    private int menuOrder;   //菜单顺序
    private String owner;      //所属系统
    private String belong;      //所属模块

    @Id
    @Column(name = "MENU_ID", length = 64,nullable = false)
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "MENU_NAME", length = 50,nullable = false)
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "MENU_DES", length = 100)
    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    @Basic
    @Column(name = "MENYU_STATE", length = 2)
    public int getMenuState() {
        return menuState;
    }

    public void setMenuState(int menuState) {
        this.menuState = menuState;
    }

    @Basic
    @Column(name = "MENU_URL", length = 200)
    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Basic
    @Column(name = "MENU_LEVEL", length = 2)
    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }

    @Basic
    @Column(name = "PARENT_MENU_ID", length = 64)
    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    @Basic
    @Column(name = "CHILD_FLAG", length = 2)
    public int getChildFlag() {
        return childFlag;
    }

    public void setChildFlag(int childFlag) {
        this.childFlag = childFlag;
    }

    @Basic
    @Column(name = "MENU_ORDER", length = 2)
    public int getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
    }

    @Basic
    @Column(name = "OWNER", length = 50)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "BELONG", length = 50)
    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }
}
