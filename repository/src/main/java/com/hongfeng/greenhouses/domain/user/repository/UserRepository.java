package com.hongfeng.greenhouses.domain.user.repository;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.user.model.UserInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2017/10/20.
 */
public interface UserRepository {
    /**
     * 根据参数获取用户信息
     *
     * @param userInfoEntity
     * @return
     */
    UserInfoEntity getUserInfoByParameter(UserInfoEntity userInfoEntity);

    /**
     * 分页获取用户信息列表
     *
     * @param map
     * @param webPage
     * @return
     */
    List<UserInfoEntity> getUserInfoList(Map map, WebPage webPage);

    void addUserInfo(UserInfoEntity userInfoEntity);

    UserInfoEntity getUserInfoById(String userId);

    /**
     * 编辑用户信息
     *
     * @param userInfoEntity
     */
    void editUserInfo(UserInfoEntity userInfoEntity);

    /**
     * 删除用户信息
     *
     * @param userInfoEntity
     */
    void deleteUserInfo(UserInfoEntity userInfoEntity);
}
