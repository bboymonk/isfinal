package com.isfinal.module.service;


import com.github.pagehelper.PageInfo;
import com.isfinal.base.BaseService;
import com.isfinal.module.model.UserInfo;

/**
 * Created by wjb on 2018/11/10.
 */
public interface UserInfoService extends BaseService<UserInfo,String> {

    PageInfo<UserInfo> getUser();

    UserInfo getUserInfoByUsername(String username);

}
