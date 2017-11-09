package com.hongfeng.greenhouses.domain.user.repositoryImpl;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.user.model.UserInfoEntity;
import com.hongfeng.greenhouses.domain.user.repository.UserRepository;
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
 * Created by Jiazefeng on 2017/10/20.
 */
@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<UserInfoEntity> implements UserRepository {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public UserInfoEntity getUserInfoByParameter(UserInfoEntity userInfoEntity) {
        String hql = " FROM UserInfoEntity WHERE userName = '" + userInfoEntity.getUserName() + "' and password='" + userInfoEntity.getPassword() + "' and userState='" + userInfoEntity.getUserState() + "' ";
        Query query = getCurrentSession().createQuery(hql);
        return (UserInfoEntity) query.uniqueResult();
    }

    @Override
    public List<UserInfoEntity> getUserInfoList(Map map, WebPage webPage) {
        List<Object> params = new ArrayList<Object>();
        String hql = " from UserInfoEntity ue where 1=1 ";
        hql += " and ue.userState=1 order by ue.modifyOn desc";
        if (map.get("userName") != null && !"".equals(map.get("userName").toString())) {
            hql += " and ue.userName = '" + map.get("userName").toString() + "' ";
        }
        if (map.get("userRealName") != null && !"".equals(map.get("userRealName").toString())) {
            hql += " and ue.userRealName = '" + map.get("userRealName").toString() + "' ";
        }
        if (webPage != null) {
            return this.findByPage(hql, webPage, params);
        }
        List<UserInfoEntity> userInfoEntityList = (List<UserInfoEntity>) getHibernateTemplate().find(hql, params);
        return userInfoEntityList;
    }

    @Override
    public void addUserInfo(UserInfoEntity userInfoEntity) {
        this.save(userInfoEntity);
    }

    @Override
    public UserInfoEntity getUserInfoById(String userId) {
        String hql = " FROM UserInfoEntity WHERE userId = '" + userId + "' and userState=1 ";
        Query query = getCurrentSession().createQuery(hql);
        return (UserInfoEntity) query.uniqueResult();
    }

    @Override
    public void editUserInfo(UserInfoEntity userInfoEntity) {
        this.update(userInfoEntity);
    }

    @Override
    public void deleteUserInfo(UserInfoEntity userInfoEntity) {

    }
}
