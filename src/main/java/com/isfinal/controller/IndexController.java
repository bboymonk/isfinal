package com.isfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wjb on 2018/1/26.
 */
@Controller
public class IndexController {
    @GetMapping("index")
    public String index(HttpServletRequest request){
        return "index";
    }
}
