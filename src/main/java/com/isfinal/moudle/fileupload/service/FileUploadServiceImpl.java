package com.isfinal.moudle.fileupload.service;

import com.alibaba.druid.util.StringUtils;
import com.isfinal.base.BaseMapper;
import com.isfinal.base.BaseServiceImpl;
import com.isfinal.util.ExecuteUpload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by wjb on 2018/1/27.
 */
@Service
public class FileUploadServiceImpl extends BaseServiceImpl implements FileUploadService {
    @Override
    public BaseMapper getMapper() {
        return null;
    }

    @Transactional
    @Override
    public String singleFile(MultipartFile file, String savePath) {
        try {
            ExecuteUpload.upload(file, savePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Transactional
    @Override
    public String arrayFile(MultipartFile[] files, String savePath) {
        try {
            for (MultipartFile f : files) {
                if (!StringUtils.isEmpty(f.getName())) {
                    ExecuteUpload.upload(f, savePath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
