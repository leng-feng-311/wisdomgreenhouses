package com.hongfeng.greenhouses.domain.equipment.repository;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.equipment.model.EquipmentEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2017/11/9.
 */
public interface EquipmentRepository {
    /**
     * 分页获取设备列表信息
     *
     * @param map
     * @param webPage
     * @return
     */
    List<EquipmentEntity> getEquipmentList(Map map, WebPage webPage);

    /**
     * 根据ID获取对应的信息
     *
     * @param s
     * @return
     */
    EquipmentEntity getEquipmentByEId(String s);

    /**
     * 新增、编辑信息
     *
     * @param equipmentEntity
     */
    void addOrUpdate(EquipmentEntity equipmentEntity);
}
