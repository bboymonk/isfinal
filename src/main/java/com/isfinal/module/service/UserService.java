package com.isfinal.module.service;


import com.github.pagehelper.PageInfo;
import com.isfinal.base.BaseService;
import com.isfinal.module.model.User;

/**
 * Created by wjb on 2018/11/10.
 */
public interface UserService extends BaseService<User,String> {

    PageInfo<User> getUser();

    User getUserByUsername(String username);

}
