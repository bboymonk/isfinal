package com.isfinal.base;

import java.io.Serializable;


public interface BaseMapper<T,ID extends Serializable> {
    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    int getCount();


}
