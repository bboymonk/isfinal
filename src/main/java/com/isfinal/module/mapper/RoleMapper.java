package com.isfinal.module.mapper;

import com.isfinal.base.BaseMapper;
import com.isfinal.module.model.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role,String> {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getRoles(String id);

}