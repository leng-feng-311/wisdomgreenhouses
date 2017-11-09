package com.hongfeng.greenhouses.domain.user.repositoryImpl;

import com.hongfeng.greenhouses.domain.user.model.UserLoginLogEntity;
import com.hongfeng.greenhouses.domain.user.repository.UserLoginLogRepository;
import com.hongfeng.greenhouses.hibernate.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Jiazefeng on 2017/10/20.
 */
@Repository
public class UserLoginLogRepositoryImpl extends BaseRepositoryImpl<UserLoginLogEntity> implements UserLoginLogRepository {

    @Override
    public void addUserLoginLog(UserLoginLogEntity userLoginLogEntity) {
        this.save(userLoginLogEntity);
    }
}
