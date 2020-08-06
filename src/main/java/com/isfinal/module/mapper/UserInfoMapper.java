package com.isfinal.module.mapper;

import com.isfinal.base.BaseMapper;
import com.isfinal.module.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo,String> {

    List<UserInfo> getUser();

    UserInfo getUserInfoByUsername(String username);

}