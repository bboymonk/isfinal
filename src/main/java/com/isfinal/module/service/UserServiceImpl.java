package com.isfinal.module.service;

import com.github.pagehelper.PageInfo;
import com.isfinal.base.BaseMapper;
import com.isfinal.base.BaseServiceImpl;
import com.isfinal.module.mapper.UserInfoMapper;
import com.isfinal.module.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wjb on 2018/11/10.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserInfo,Integer> implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public BaseMapper getMapper() {
        return userInfoMapper;
    }

    @Override
    public PageInfo<UserInfo> getUser(){
        List<UserInfo> list = userInfoMapper.getUser();
        return new PageInfo<UserInfo>(list);
    }


}
