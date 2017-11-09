package com.hongfeng.greenhouses.domain.user.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * 用户登录TOKEN信息
 * Created by Jiazefeng on 2017/10/20.
 */
@Entity
@Table(name = "USER_LOGIN_BOOK")
public class UserLoginBook extends BaseVo {
    private String tokenId;
    private String userId;
    private Date makeDate;
    private Time makeTime;
    private String loginType;

    @Id
    @Column(name = "TOKEN_ID", nullable = false, length = 64)
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
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
    @Column(name = "MAKE_DATE")
    public Date getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }
    @Basic
    @Column(name = "MAKE_TIME")
    public Time getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Time makeTime) {
        this.makeTime = makeTime;
    }

    @Basic
    @Column(name = "LOGIN_TYPE", length = 20)
    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

}
