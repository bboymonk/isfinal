package com.isfinal.controller;

import com.isfinal.base.BaseController;
import com.isfinal.module.model.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/isfinal")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    /**
     * 用户注册
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/register")
    private String register(HttpServletRequest request, HttpServletResponse response, UserInfo userInfo){


        return null;
    }


    /**
     * 用户登录
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/login")
    private String login(HttpServletRequest request, HttpServletResponse response){
        SecurityUtils.getSubject();

        return null;
    }



}
