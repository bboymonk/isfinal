package com.isfinal.module.service;

import com.github.pagehelper.PageInfo;
import com.isfinal.base.BaseService;
import com.isfinal.module.model.UserInfo;

import java.util.List;

/**
 * Created by wjb on 2018/11/10.
 */
public interface UserService extends BaseService<UserInfo,Integer>{

    PageInfo<UserInfo> getUser();

}
