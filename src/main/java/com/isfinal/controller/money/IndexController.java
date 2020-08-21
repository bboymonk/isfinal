package com.isfinal.controller.money;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isfinal.base.BaseController;
import com.isfinal.module.model.User;
import com.isfinal.module.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by wjb on 2018/1/26.
 */
@Controller
public class IndexController extends BaseController {

    private static final Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "view/tree";
    }

    @GetMapping("/editor")
    public String editor() {
        return "view/editor";
    }

    @GetMapping("/notice")
    public String notice() {
        return "view/notice";
    }

    @GetMapping("/bboy/User")
    public String User() {
        return "index";
    }


    @ResponseBody
    @GetMapping("/getUsers")
    public String getUser(Integer page,Integer limit) {
        try {
            PageHelper.startPage(page == null ? 1 : page,limit == null ? 10 : limit);
            PageInfo<User> pageInfo = userService.getUser();
            return SUCCESS_FAIL_N(true,pageInfo, "success");
        } catch (Exception e) {
            logger.error("query error", e);
            return SUCCESS_FAIL_N(false, null, "query error");
        }
    }


    @ResponseBody
    @PostMapping("/addUser")
    public String addUser(User User) {
        try {
            User.setCreateTime(new Date());
            int i = userService.insertSelective(User);
            return SUCCESS_FAIL_N(true,i, "success");
        } catch (Exception e) {
            logger.error("add user error", e);
            return SUCCESS_FAIL_N(false, 0, "add user error");
        }
    }



}
