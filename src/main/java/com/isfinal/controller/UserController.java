package com.isfinal.controller;

import com.isfinal.moudle.user.model.User;
import com.isfinal.moudle.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wjb on 2018/1/26.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("login")
    public User login() {
        System.out.println("helloworld");

        return userService.selectByPrimaryKey(1);
    }


}
