package com.isfinal.module.mapper;

import com.isfinal.base.BaseMapper;
import com.isfinal.module.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User,String> {

    List<User> getUser();

    User getUserByUsername(String username);

}