package com.isfinal.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.isfinal.base.BaseController;
import com.isfinal.moudle.user.model.User;
import com.isfinal.moudle.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wjb on 2018/1/26.
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController{
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate template;


    @ResponseBody
    @GetMapping("login")
    public User login() {
        return userService.selectByPrimaryKey(1);
    }

    @ResponseBody
    @GetMapping("wxlogin")
    public String weChatLogin(String code){
        String data = restTemplate.getForObject("https://api.weixin.qq.com/sns/jscode2session?appid=wx27bd0a5e2a28f8d0&secret=931445a58f7a8b06d3f08509e9f78b72&js_code="+code+"&grant_type=authorization_code", String.class);
        JSONObject jsonObject = JSONObject.parseObject(data);
        String session_key = (String) jsonObject.get("session_key");
        String openid = (String) jsonObject.get("openid");
        ValueOperations<String, String> operations = template.opsForValue();
        operations.set("wjb",session_key+openid);
        return data;
    }



}
