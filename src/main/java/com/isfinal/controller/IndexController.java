package com.isfinal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isfinal.base.BaseController;
import com.isfinal.module.model.UserInfo;
import com.isfinal.module.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wjb on 2018/1/26.
 */
@Controller
public class IndexController extends BaseController {

    private static final Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/bboyOrDie")
    public String index() {
        return "index";
    }


    @ResponseBody
    @GetMapping("/getUsers")
    public String getUser(Integer page,Integer limit) {
        try {
            PageHelper.startPage(page == null ? 1 : page,limit == null ? 10 : limit);
            PageInfo<UserInfo> pageInfo = userService.getUser();
            return SUCCESS_FAIL_N(true,pageInfo, "success");
        } catch (Exception e) {
            logger.error("query error", e);
            return SUCCESS_FAIL_N(false, null, "query error");
        }
    }


    @ResponseBody
    @GetMapping("/addUser")
    public String addUser(UserInfo userInfo) {
        try {
            int i = userService.insertSelective(userInfo);
            return SUCCESS_FAIL_N(true,i, "success");
        } catch (Exception e) {
            logger.error("query error", e);
            return SUCCESS_FAIL_N(false, 0, "query error");
        }
    }



}
