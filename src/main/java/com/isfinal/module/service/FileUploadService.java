package com.isfinal.module.service;

import com.isfinal.base.BaseService;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by wjb on 2018/1/27.
 */
public interface FileUploadService extends BaseService {

    String singleFile(MultipartFile file,String savePath);

    String arrayFile(MultipartFile[] files,String savePath);

}
