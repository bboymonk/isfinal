//package com.isfinal.controller.wechat;
//
//import com.alibaba.druid.util.StringUtils;
//import com.alibaba.fastjson.JSONObject;
//import com.isfinal.base.BaseController;
//import com.isfinal.moudle.user.model.User;
//import com.isfinal.moudle.user.service.UserInfoService;
//import com.isfinal.util.Global;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by wjb on 2018/1/26.
// */
//@Controller
//@RequestMapping("user")
//public class UserController extends BaseController {
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private UserInfoService userService;
//    @Autowired
//    private StringRedisTemplate template;
//
//    @ResponseBody
//    @GetMapping("list")
//    public String list() {
//        User list = null;
//        try {
//            list = userService.list(1L);
//            return SUCCESS_FAIL_N(true, list, null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return SUCCESS_FAIL_N(false, list, "查询失败");
//        }
//    }
//
//
//    /**
//     * 微信登录凭证获取openid和session_key
//     * 自定义session
//     *
//     * @param code
//     * @return
//     */
//    @ResponseBody
//    @GetMapping("wxlogin")
//    public String weChatLogin(String code) {
//        String wx_session = null;
//        try {
//            String data = restTemplate.getForObject("https://api.weixin.qq.com/sns/jscode2session?appid=" + Global.APPID + "&secret=" + Global.SECRET + "&js_code=" + code + "&grant_type=authorization_code", String.class);
//            JSONObject jsonObject = JSONObject.parseObject(data);
//            String session_key = (String) jsonObject.get("session_key");
//            String openid = (String) jsonObject.get("openid");
//            ValueOperations<String, String> operations = template.opsForValue();
//            wx_session = Global.getRandom();
//            System.out.println(wx_session);
//            operations.set(wx_session, session_key + openid);
//            template.expire(wx_session, 60 * 60 * 60, TimeUnit.SECONDS);
//        } catch (RestClientException e) {
//            e.printStackTrace();
//            return SUCCESS_FAIL_N(false, null, "error");
//        }
//        return SUCCESS_FAIL_N(true, wx_session, null);
//    }
//
//    /**
//     * 添加用户信息
//     *
//     * @return
//     * @param: nickName avatarUrl gender info  country province  city
//     */
//    @ResponseBody
//    @GetMapping("add")
//    public String setUserInfo(User user) {
//        if (StringUtils.isEmpty(user.getNickName())) {
//            return SUCCESS_FAIL_N(false, null, "nickName is null");
//        }
//        if (StringUtils.isEmpty(user.getAvatarUrl())) {
//            return SUCCESS_FAIL_N(false, null, "avatarUrl is null");
//        }
//        if (user.getGender() < 0) {
//            return SUCCESS_FAIL_N(false, null, "gender is error");
//        }
//        try {
//            userService.insertSelective(user);
//            return SUCCESS_FAIL_N(true, "success", null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return SUCCESS_FAIL_N(false, "success", "添加用户失败");
//        }
//    }
//
//}
