package com.isfinal.config;

import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;


/**
 * Created by Administrator on 2017/11/16.
 */
@Component
public class FreeMarkerConfig {
    @Value("${ctx}")
    private String ctx;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    private Configuration configuration;

    @Bean
    public Configuration getFreeMarkerConfiguration(){
        return freeMarkerConfigurer.getConfiguration();
    }

    // Spring 初始化的时候加载配置
    @PostConstruct
    public void setConfigure() throws Exception {
        // 加载html的资源路径
        configuration.setSharedVariable("ctx", ctx);

    }

}
