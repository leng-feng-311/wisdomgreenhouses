package com.hongfeng.greenhouses.domain.equipment.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;

/**
 * 设备信息
 * Created by Jiazefeng on 2017/11/9.
 */
@Entity
@Table(name = "EQUIPMENT")
public class EquipmentEntity extends BaseVo {
    private int id;//自增ID
    private String eId;//设备ID
    private String eName;//设备名称
    private String eNumber;//设备编号
    private String eLocation;//设备产地
    private Date eTimeBuying;//设备购买时间
    private String eDescribe;//设备描述
    private String eState;//设备状态

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
    @Column(name = "E_ID", nullable = false, length = 64)
    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    @Basic
    @Column(name = "E_NAME", nullable = false, length = 64)
    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Basic
    @Column(name = "E_NUMBER", nullable = false, length = 64)
    public String geteNumber() {
        return eNumber;
    }

    public void seteNumber(String eNumber) {
        this.eNumber = eNumber;
    }

    @Basic
    @Column(name = "E_LOCATION", nullable = false, length = 128)
    public String geteLocation() {
        return eLocation;
    }

    public void seteLocation(String eLocation) {
        this.eLocation = eLocation;
    }

    @Basic
    @Column(name = "E_TIMEBUYING", nullable = false)
    public Date geteTimeBuying() {
        return eTimeBuying;
    }

    public void seteTimeBuying(Date eTimeBuying) {
        this.eTimeBuying = eTimeBuying;
    }

    @Basic
    @Column(name = "E_DESCRIBE", nullable = false, length = 200)
    public String geteDescribe() {
        return eDescribe;
    }

    public void seteDescribe(String eDescribe) {
        this.eDescribe = eDescribe;
    }

    @Basic
    @Column(name = "ESTATE", nullable = false, length = 6)
    public String geteState() {
        return eState;
    }

    public void seteState(String eState) {
        this.eState = eState;
    }
}
