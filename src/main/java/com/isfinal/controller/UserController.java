package com.isfinal.controller;

import com.github.pagehelper.PageInfo;
import com.isfinal.base.BaseController;
import com.isfinal.config.jwt.JwtUtil;
import com.isfinal.config.shiro.ShiroKit;
import com.isfinal.module.model.User;
import com.isfinal.module.service.UserService;
import com.isfinal.util.ResultDto;
import com.isfinal.util.ResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/isfinal")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
     * 用户注册
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/register")
    private String register(HttpServletRequest request, HttpServletResponse response, User user){
        try {
            if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassWord())){
                return SUCCESS_FAIL_N(false,null,"userName or passWord can not be null");
            }
            String md5Pwd = ShiroKit.md5(user.getPassWord(), user.getUserName());


            ResultUtils.sendObject(response,null);
            return SUCCESS_FAIL_N(true,null,null);
        } catch (Exception e) {
            logger.error("用户注册发生异常",e);
            return SUCCESS_FAIL_N(false,null,"用户注册发生异常");
        }
    }


    /**
     * 用户登录
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/login")
    private String login(HttpServletRequest request, HttpServletResponse response,User user){
        try {
            if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassWord())){
                return SUCCESS_FAIL_N(false,null,"userName or passWord can not be null");
            }
            User u = userService.getUserByUsername(user.getUserName());
            if (null == u){
                return SUCCESS_FAIL_N(false,null,"用户名不正确");
            }
            String md5Pwd = ShiroKit.md5(u.getPassWord(), u.getUserName());
            if (!u.getPassWord().equals(md5Pwd)){
                return SUCCESS_FAIL_N(false,null,"用户密码不正确");
            }
            String token = JwtUtil.sign(u.getUserName(), u.getPassWord());
            response.setHeader("token",token);
            return SUCCESS_FAIL_N(true,token,null);
        } catch (Exception e) {
            logger.error("login error",e);
            return SUCCESS_FAIL_N(false,null,"login error");
        }
    }


    @GetMapping("/getUser")
    private void getUser(HttpServletRequest request, HttpServletResponse response,User user){
        try {
            if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassWord())){
                ResultUtils.sendObject(response, ResultDto.fail("-1","userName or passWord can not be null"));
                return;
            }
            PageInfo<User> users = userService.getUser();
            ResultUtils.sendObject(response, ResultDto.success(users));
        } catch (Exception e) {
            logger.error("getUser error",e);
            ResultUtils.sendObject(response, ResultDto.fail("-1","getUser error"));
        }
    }


}
