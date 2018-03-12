package com.isfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

/**
 * Created by wjb on 2018/1/26.
 */
@Controller
public class IndexController {
    @ResponseBody
    @GetMapping("/")
    public String index(HttpServletRequest request) throws FileNotFoundException {
        return "我的新域名，能不能发财就靠它了";
    }
}
