package com.hongfeng.greenhouses.domain.user.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户信息
 * Created by Jiazefeng on 2017/10/16.
 */
@Entity
@Table(name = "USER_INFO")
public class UserInfoEntity extends BaseVo {
    private int id;//自增长ID
    private String userId;//用户ID
    private String userName;//用户名
    private String userRealName;//用户真实名字
    private String password;//用户密码
    private String userPhone;//用户手机号
    private String userLogo;//用户头像
    private int userSex;//用户性别 1:男；2：女；3：保密
    private Date userBirthday;//用户生日
    private String userEmail;//用户邮箱
    private String userRemark;//用户备注
    private int userState;//用户状态 1：在线；2：离线

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_ID", length = 64, nullable = false)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_NAME", length = 64, nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_REAL_NAME", length = 64)
    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    @Basic
    @Column(name = "PASSWORD", length = 64, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "USER_PHONE", length = 15)
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "USER_LOGO", length = 128)
    public String getUserLogo() {
        return userLogo;
    }

    public void setUserLogo(String userLogo) {
        this.userLogo = userLogo;
    }

    @Basic
    @Column(name = "USER_SEX", length = 2)
    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "USER_BIRTHDAT")
    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Basic
    @Column(name = "USER_EMAIL", length = 64)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "USER_REMARK", length = 128)
    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    @Basic
    @Column(name = "USER_STATE", length = 2)
    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }
}
