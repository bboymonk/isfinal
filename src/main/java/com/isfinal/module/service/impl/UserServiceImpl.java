package com.isfinal.module.service.impl;

import com.github.pagehelper.PageInfo;
import com.isfinal.base.BaseMapper;
import com.isfinal.base.BaseServiceImpl;
import com.isfinal.module.mapper.UserMapper;
import com.isfinal.module.model.User;
import com.isfinal.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wjb on 2018/11/10.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,String> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper getMapper() {
        return userMapper;
    }

    @Override
    public PageInfo<User> getUser() {
        List<User> user = userMapper.getUser();
        return new PageInfo<User>(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }


}
