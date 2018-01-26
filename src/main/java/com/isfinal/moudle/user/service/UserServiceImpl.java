package com.isfinal.moudle.user.service;

import com.isfinal.base.BaseMapper;
import com.isfinal.base.BaseServiceImpl;
import com.isfinal.moudle.user.mapper.UserMapper;
import com.isfinal.moudle.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wjb on 2018/1/26.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper getMapper() {
        return userMapper;
    }





}
