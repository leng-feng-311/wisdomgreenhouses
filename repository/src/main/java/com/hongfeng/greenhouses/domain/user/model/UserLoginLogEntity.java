package com.hongfeng.greenhouses.domain.user.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户登录日志信息
 * Created by Jiazefeng on 2017/10/16.
 */
@Entity
@Table(name = "USER_LOGIN_LOG")
public class UserLoginLogEntity extends BaseVo {
    private String logId;//日志ID
    private String userName;//用户名
    private String staffName;//名称
    private String userMobile;//手机号
    private String sourceFrom;// 来源
    private Date sysTime;// 时间
    private String sysContent;//内容
    private String ipAddress;//ip地址

    @Id
    @Column(name = "ID", nullable = false, length = 50)
    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "STAFF_NAME", nullable = true, length = 50)
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Basic
    @Column(name = "USER_MOBILE", nullable = true, length = 50)
    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    @Basic
    @Column(name = "SOURCE_FROM", nullable = true, length = 50)
    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }


    @Basic
    @Column(name = "SYS_CONTENT", nullable = true, length = 100)
    public String getSysContent() {
        return sysContent;
    }

    public void setSysContent(String sysContent) {
        this.sysContent = sysContent;
    }

    @Basic
    @Column(name = "SYS_TIME", nullable = true)
    public Date getSysTime() {
        return sysTime;
    }

    public void setSysTime(Date sysTime) {
        this.sysTime = sysTime;
    }

    @Basic
    @Column(name = "IP_ADDRESS", nullable = true, length = 50)
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
