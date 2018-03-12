package com.isfinal.moudle.user.service;

import com.isfinal.base.BaseMapper;
import com.isfinal.base.BaseServiceImpl;
import com.isfinal.moudle.user.mapper.ContentMapper;
import com.isfinal.moudle.user.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wjb on 2018/2/4.
 */
@Service
public class ContentServiceImpl extends BaseServiceImpl<Content,Long> implements ContentService {
    @Autowired
    private ContentMapper contentMapper;
    @Override
    public BaseMapper getMapper() {
        return contentMapper;
    }

}
