package com.isfinal.controller.wechat;

import com.isfinal.base.BaseController;
import com.isfinal.moudle.user.model.Content;
import com.isfinal.moudle.user.service.ContentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by wjb on 2018/2/4.
 */
@Controller
@RequestMapping("content")
public class ContentController extends BaseController {
    private static final Logger logger = Logger.getLogger(ContentController.class);
    @Autowired
    private ContentService contentService;

    /**
     * 内容列表
     */
    @ResponseBody
    @GetMapping("list")
    public String list() {

        return SUCCESS_FAIL_N(true,null,null);
    }

    /**
     * 发表内容
     *
     * @param :content address files[]
     * @return
     */
    @ResponseBody
    @GetMapping("add")
    public String addContent(Content content, MultipartFile[] files) {


        return null;
    }


}
