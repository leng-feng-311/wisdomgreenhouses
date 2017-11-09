package com.hongfeng.greenhouses.domain.user.repositoryImpl;

import com.hongfeng.greenhouses.domain.user.model.UserLoginBook;
import com.hongfeng.greenhouses.domain.user.repository.UserLoginBookRepository;
import com.hongfeng.greenhouses.hibernate.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Jiazefeng on 2017/10/20.
 */
@Repository
public class UserLoginBookRepositoryImpl extends BaseRepositoryImpl<UserLoginBook> implements UserLoginBookRepository {
    @Override
    public boolean addUserLoginBook(UserLoginBook userLoginBook) {
        this.save(userLoginBook);
        return true;
    }
}
