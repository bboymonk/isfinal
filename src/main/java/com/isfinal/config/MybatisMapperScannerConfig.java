package com.isfinal.config;

import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

/**
 * Created by Administrator on 2017/11/16.
 */
@Configuration
@MapperScan(basePackages = "com.isfinal.*.mapper")
public class MybatisMapperScannerConfig {
    private static final Logger logger = Logger.getLogger(MybatisMapperScannerConfig.class);

    @Bean
    public PageHelper pageHelper(){
        logger.info("------pageHelper");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

}
