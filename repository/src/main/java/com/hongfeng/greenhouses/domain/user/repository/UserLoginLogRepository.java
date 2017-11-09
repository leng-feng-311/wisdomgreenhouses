package com.hongfeng.greenhouses.domain.user.repository;

import com.hongfeng.greenhouses.domain.user.model.UserLoginLogEntity;

/**
 * Created by Jiazefeng on 2017/10/20.
 */
public interface UserLoginLogRepository {
    /**
     * 新增登录日志信息
     *
     * @param userLoginLogEntity
     */
    void addUserLoginLog(UserLoginLogEntity userLoginLogEntity);
}
