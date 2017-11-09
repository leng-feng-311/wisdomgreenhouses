package com.hongfeng.greenhouses.domain.equipment.dto;

/**
 * Created by Jiazefeng on 2017/11/9.
 */
public class EquipmentDTO {
    private String eId;//设备ID
    private String eName;//设备名称
    private String eNumber;//设备编号
    private String eLocation;//设备产地
    private String eTimeBuying;//设备购买时间
    private String eDescribe;//设备描述
    private String eState;//设备状态
    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteNumber() {
        return eNumber;
    }

    public void seteNumber(String eNumber) {
        this.eNumber = eNumber;
    }

    public String geteLocation() {
        return eLocation;
    }

    public void seteLocation(String eLocation) {
        this.eLocation = eLocation;
    }

    public String geteTimeBuying() {
        return eTimeBuying;
    }

    public void seteTimeBuying(String eTimeBuying) {
        this.eTimeBuying = eTimeBuying;
    }

    public String geteDescribe() {
        return eDescribe;
    }

    public void seteDescribe(String eDescribe) {
        this.eDescribe = eDescribe;
    }

    public String geteState() {
        return eState;
    }

    public void seteState(String eState) {
        this.eState = eState;
    }
}
