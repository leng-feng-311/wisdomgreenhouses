package com.hongfeng.greenhouses.domain.menu.repositoryImpl;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.menu.model.MenuModel;
import com.hongfeng.greenhouses.domain.menu.repository.MenuRepository;
import com.hongfeng.greenhouses.hibernate.BaseRepository;
import com.hongfeng.greenhouses.hibernate.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2017/10/18.
 */
@Repository
public class MenuRepositoryImpl extends BaseRepositoryImpl<MenuModel> implements MenuRepository {
    @Override
    public boolean addMenuModel(MenuModel newMenu) {
        if (newMenu != null) {
            this.save(newMenu);
            return true;
        }
        return false;
    }

    @Override
    public List<MenuModel> getMenuEntityList(Map map, WebPage webPage) {
        List<Object> params = new ArrayList<Object>();
        String hql = " from MenuModel mm where 1=1 ";
//        if (map.get("projectId") != null && !"".equals(map.get("projectId").toString())) {
//            hql += " and kp.projectId = '" + map.get("projectId").toString() + "' ";
//        } else {
//            hql += " and (kp.projectId in(" + projectId1s + ") or kp.projectId in(" + projectId2s + ")) ";
//        }
//        if (map.get("buildingId") != null && !"".equals(map.get("buildingId").toString())) {
//            hql += " and kp.buildingId = '" + map.get("buildingId").toString() + "' ";
//        }
//        if (map.get("startDate") != null && !"".equals(map.get("startDate").toString())) {
//            String startDate = map.get("startDate").toString() + " 00:00:00";
//            hql += " and kp.createOn >= '" + startDate + "' ";
//        }
//        if (map.get("endDate") != null && !"".equals(map.get("endDate").toString())) {
//            String endDate = map.get("endDate").toString() + " 23:59:59";
//            hql += " and kp.createOn <= '" + endDate + "' ";
//        }
        hql += " and mm.menuState = 1 ";
        hql += " order by mm.menuOrder asc ";

        if (webPage != null) {
            return this.findByPage(hql, webPage, params);
        }
        List<MenuModel> menuModelList = (List<MenuModel>) getHibernateTemplate().find(hql, params.toArray());
        return menuModelList;
    }
}
