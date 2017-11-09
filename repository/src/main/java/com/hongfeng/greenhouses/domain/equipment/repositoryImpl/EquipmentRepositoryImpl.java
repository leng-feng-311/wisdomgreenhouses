package com.hongfeng.greenhouses.domain.equipment.repositoryImpl;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.equipment.model.EquipmentEntity;
import com.hongfeng.greenhouses.domain.equipment.repository.EquipmentRepository;
import com.hongfeng.greenhouses.hibernate.BaseRepositoryImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2017/11/9.
 */
@Repository
public class EquipmentRepositoryImpl extends BaseRepositoryImpl<EquipmentEntity> implements EquipmentRepository {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<EquipmentEntity> getEquipmentList(Map map, WebPage webPage) {
        List<Object> params = new ArrayList<Object>();
        String hql = " from EquipmentEntity ee where 1=1 ";
        hql += " order by ee.modifyOn desc";
        if (map.get("eName") != null && !"".equals(map.get("eName").toString())) {
            hql += " and ee.eName like '%" + map.get("eName").toString() + "% '";
        }
        if (map.get("eNumber") != null && !"".equals(map.get("eNumber").toString())) {
            hql += " and ee.eNumber like '%" + map.get("eNumber").toString() + "%' ";
        }
        if (webPage != null) {
            return this.findByPage(hql, webPage, params);
        }
        List<EquipmentEntity> userInfoEntityList = (List<EquipmentEntity>) getHibernateTemplate().find(hql, params);
        return userInfoEntityList;
    }

    @Override
    public EquipmentEntity getEquipmentByEId(String s) {
        String hql = " FROM EquipmentEntity WHERE eId = '" + s + "'";
        Query query = getCurrentSession().createQuery(hql);
        return (EquipmentEntity) query.uniqueResult();
    }

    @Override
    public void addOrUpdate(EquipmentEntity equipmentEntity) {
        this.saveOrUpdate(equipmentEntity);
    }
}
