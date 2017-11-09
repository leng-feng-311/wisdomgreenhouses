package com.hongfeng.greenhouses.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.rmi.PortableRemoteObject;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jiazefeng on 2017/10/13.
 */
@MappedSuperclass
public class BaseVo implements Serializable {
    protected String createById;//创建人的ID
    protected String createByName;//创建人的名称
    protected String modifyById;//修改人的ID
    protected String modifyByName;//修改人的名称
    protected Date createOn;//创建时间
    protected Date modifyOn;//修改时间

    @Basic
    @Column(name = "CREATE_BY_ID", length = 64)
    public String getCreateById() {
        return createById;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }
    @Basic
    @Column(name = "CREATE_BY_NAME", length = 200)
    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }
    @Basic
    @Column(name = "MODIFY_BY_ID", length = 64)
    public String getModifyById() {
        return modifyById;
    }

    public void setModifyById(String modifyById) {
        this.modifyById = modifyById;
    }
    @Basic
    @Column(name = "MODIFY_BY_NAME", length = 200)
    public String getModifyByName() {
        return modifyByName;
    }

    public void setModifyByName(String modifyByName) {
        this.modifyByName = modifyByName;
    }
    @Basic
    @Column(name = "CREATE_ON")
    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }
    @Basic
    @Column(name = "MODIFY_ON")
    public Date getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(Date modifyOn) {
        this.modifyOn = modifyOn;
    }
}
