package com.isfinal.moudle.user.mapper;

import com.isfinal.base.BaseMapper;
import com.isfinal.moudle.user.model.User;

public interface UserMapper extends BaseMapper<User,Long>{
    User list(Long id);
}