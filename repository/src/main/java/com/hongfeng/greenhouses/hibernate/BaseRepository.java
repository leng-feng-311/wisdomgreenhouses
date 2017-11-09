package com.hongfeng.greenhouses.hibernate;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.menu.model.MenuModel;

import java.util.List;

/**
 * Created by Jiazefeng on 2017/10/18.
 */
public interface BaseRepository<PO> {
    void save(PO entity);
    void update(PO entity);
    void saveOrUpdate(PO entity);
    /**
     * 统计总条数
     */
    public Integer count(String hql);
    /**
     * 根据条件统计总条数
     */
    public Integer count(String hql, Object... obj);
    /**
     * 多条件分页查询
     */
    public <E> List<E> findByPage(String queryString, Integer startRow, Integer pageSize, Object... params);
    /**
     * 多条件分页查询
     * @param queryString HQL语句
     * @param params   参数集合
     * @return 分页查询结果
     */
    public <E> List<E> findByPage(String queryString, WebPage pageModel, List<?> params);
}
