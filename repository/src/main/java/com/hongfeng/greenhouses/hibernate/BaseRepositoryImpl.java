package com.hongfeng.greenhouses.hibernate;

import com.hongfeng.common.tool.WebPage;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jiazefeng on 2017/10/18.
 */
@Repository
public class BaseRepositoryImpl<PO extends BaseVo> extends HibernateDaoSupport implements BaseRepository<PO> {
    private Class<PO> persistentClass;

    @Resource(name = "hibernateTemplate")
    protected HibernateTemplate hibernateTemplate;

    @PostConstruct
    public void initHibernateTemplate() {
        super.setHibernateTemplate(hibernateTemplate);
    }
    public Class<PO> getPersistentClass() {
        if (this.persistentClass == null) {
            this.persistentClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return persistentClass;
    }

    @Override
    public void save(PO entity) {
       getHibernateTemplate().save(entity);
    }

    @Override
    public void update(PO entity) {
       getHibernateTemplate().update(entity);
    }

    @Override
    public void saveOrUpdate(PO entity) {
       getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public Integer count(final String hql) {
        if (StringUtils.isEmpty(hql)) {
            throw new IllegalStateException("hql is null");
        }
        Object result = this.getHibernateTemplate().execute(
                new HibernateCallback<Object>() {
                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        return session.createQuery(hql).uniqueResult();
                    }
                });
        return ((Long) result).intValue();
    }

    @Override
    public Integer count(String hql, Object... obj) {
        if (ObjectUtils.isEmpty(obj)) {
            return count(hql);
        } else {
            if (StringUtils.isEmpty(hql)) {
                throw new IllegalStateException("hql is null");
            }
            Object result = this.getHibernateTemplate().execute(
                    new HibernateCallback<Object>() {

                        public Object doInHibernate(Session session)
                                throws HibernateException {
                            Query query = session.createQuery(hql);
                            for (int i = 0; i < obj.length; i++) {
                                query.setParameter(i, obj[i]);
                            }
                            return query.uniqueResult();
                        }
                    });
            return ((Long) result).intValue();
        }
    }

    @Override
    public <E> List<E> findByPage(final String hql, final Integer startRow,
                                  final Integer pageSize, final Object... params) {
        if (StringUtils.isEmpty(hql)) {
            throw new IllegalStateException("hql is null");
        }
        if (ObjectUtils.isEmpty(params)) {
            return (List<E>) getHibernateTemplate().execute(
                    new HibernateCallback<Object>() {
                        public Object doInHibernate(Session session) {
                            return session.createQuery(hql)
                                    .setFirstResult(startRow)
                                    .setMaxResults(pageSize).list();
                        }
                    });
        } else {
            return  (List<E>)getHibernateTemplate().execute(
                    new HibernateCallback<Object>() {
                        public Object doInHibernate(Session session) {
                            Query query = session.createQuery(hql);
                            for (int i = 0; i < params.length; i++) {
                                query.setParameter(i, params[i]);
                            }
                            return query.setFirstResult(startRow)
                                    .setMaxResults(pageSize).list();
                        }
                    });
        }
    }

    @Override
    public <E> List<E> findByPage(String queryString, WebPage pageModel, List<?> params) {
        String hql = queryString;
        if (queryString.toLowerCase().indexOf("where") == -1) {
            Matcher m = Pattern.compile("and").matcher(queryString);
            if (m.find()) {
                hql = m.replaceFirst("where");
            } else {
                m = Pattern.compile("AND").matcher(queryString);
                if (m.find()) {
                    hql = m.replaceFirst("WHERE");
                }
            }
        }
        int fromIndex = hql.toLowerCase().indexOf("from");
        int orderIndex = hql.toLowerCase().indexOf("group by");
        String hqlCount = "select count(*) " + hql.substring(fromIndex, orderIndex > 0 ? orderIndex : hql.length());
        int totalCount = (params == null || params.isEmpty()) ? count(hqlCount) : count(hqlCount, params.toArray());
        pageModel.setRecordCount(totalCount);
        if (totalCount == 0) {
            return new ArrayList<E>();
        }
        Object[] temps = (params == null || params.isEmpty()) ? new Object[]{}
                : params.toArray();
        return this.findByPage(hql, pageModel.getStartRow(), pageModel.getPageSize(), temps);
    }
}
