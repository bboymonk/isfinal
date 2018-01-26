package com.isfinal.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by wjb on 2018/1/27.
 * 文件上传
 */
public class ExecuteUpload {

    public static void upload(MultipartFile file, String savePath) throws IOException {
        File f = new File(savePath);
        if (!f.exists()) {
            f.mkdir();
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString().replaceAll("-", "");
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        //最终的上传文件名
        String fileName = newName + suffix;
        File saveFile = new File(savePath + fileName);
        file.transferTo(saveFile);
    }

}
