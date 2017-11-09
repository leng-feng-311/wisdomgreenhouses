package com.hongfeng.greenhouses.domain.user.repository;

import com.hongfeng.greenhouses.domain.user.model.UserLoginBook;

/**
 * Created by Jiazefeng on 2017/10/20.
 */
public interface UserLoginBookRepository {
    /**
     * 添加用户登录 TOKEN信息
     *
     * @param userLoginBook
     * @return
     */
    boolean addUserLoginBook(UserLoginBook userLoginBook);
}
