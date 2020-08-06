package com.isfinal.module.service.impl;

import com.isfinal.base.BaseMapper;
import com.isfinal.base.BaseServiceImpl;
import com.isfinal.module.mapper.RoleMapper;
import com.isfinal.module.model.Role;
import com.isfinal.module.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wjb on 2018/11/10.
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role,String> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public BaseMapper getMapper() {
        return roleMapper;
    }

    @Override
    public List<Role> getRoles(String id){
        return roleMapper.getRoles(id);
    }


}
