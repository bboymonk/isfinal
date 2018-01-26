package com.isfinal.controller;

import com.isfinal.base.BaseController;
import com.isfinal.moudle.fileupload.service.FileUploadService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;


/**
 * Created by wjb on 2018/1/26.
 */
@Controller
@RequestMapping("file")
public class FileUploadController extends BaseController {
    private static final Logger logger = Logger.getLogger(FileUploadController.class);
    @Autowired
    private FileUploadService fileUploadService;


    @ResponseBody
    @PostMapping("upload1")
    public String fileUpload(MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            return SUCCESS_FAIL_N(false, null, "文件为空");
        }
        String savePath = request.getSession().getServletContext().getRealPath(File.separator) + File.separator + "upload" + File.separator;
        String s = fileUploadService.singleFile(file, savePath);
        return SUCCESS_FAIL_N(true, s, null);
    }

    @ResponseBody
    @PostMapping("upload")
    public String moreFileUpload(MultipartFile[] file, HttpServletRequest request) {
        /**
         * 这里有个问题要注意，如果页面是<input name="file" type="file" multiple>
         *  multiple 可以一次选择多个文件。
         *      如果不传图片 length 也是 1 。
         */
        String savePath = request.getSession().getServletContext().getRealPath(File.separator) + File.separator + "upload" + File.separator;
        String s = fileUploadService.arrayFile(file, savePath);
        return SUCCESS_FAIL_N(true, s, null);
    }

}
