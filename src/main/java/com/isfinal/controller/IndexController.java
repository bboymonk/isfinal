package com.isfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

/**
 * Created by wjb on 2018/1/26.
 */
@Controller
public class IndexController {
    @GetMapping("index")
    public String index(HttpServletRequest request) throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(path);
        System.out.println(request.getSession().getServletContext().getContextPath());
        return "index";
    }
}
