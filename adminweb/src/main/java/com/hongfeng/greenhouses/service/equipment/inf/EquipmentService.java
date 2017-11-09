package com.hongfeng.greenhouses.service.equipment.inf;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.equipment.dto.EquipmentDTO;

import java.util.List;

/**
 * Created by Jiazefeng on 2017/11/9.
 */
public interface EquipmentService {
    /**
     * 分页获取设备列表信息
     *
     * @param equipmentDTO
     * @param webPage
     * @return
     */
    List<EquipmentDTO> getEquipmentListByParams(EquipmentDTO equipmentDTO, WebPage webPage);

    /**
     * 新增、编辑用户信息
     *
     * @param equipmentDTO
     */
    void addOrUpdateEquipmentInfo(EquipmentDTO equipmentDTO);

    /**
     * 根据Id获取信息
     *
     * @param eId
     * @return
     */
    EquipmentDTO getEquipmentById(String eId);

    /**
     * 删除对应的信息
     *
     * @param eId
     */
    void deleteEquipment(String eId);
}
