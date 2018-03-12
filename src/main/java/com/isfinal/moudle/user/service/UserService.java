package com.isfinal.moudle.user.service;

import com.isfinal.base.BaseService;
import com.isfinal.moudle.user.model.User;

import java.util.List;

/**
 * Created by wjb on 2018/1/26.
 */
public interface UserService extends BaseService<User,Long>{

    User list(Long id);


}
