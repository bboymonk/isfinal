package com.isfinal.module.service;


import com.isfinal.base.BaseService;
import com.isfinal.module.model.Role;

import java.util.List;

/**
 * Created by wjb on 2018/11/10.
 */
public interface RoleService extends BaseService<Role,String> {

    List<Role> getRoles(String id);

}
