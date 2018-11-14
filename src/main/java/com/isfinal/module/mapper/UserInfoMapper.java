package com.isfinal.module.mapper;

import com.isfinal.base.BaseMapper;
import com.isfinal.module.model.UserInfo;

import java.util.List;

public interface UserInfoMapper extends BaseMapper<UserInfo,Integer>{

    List<UserInfo> getUser();

}