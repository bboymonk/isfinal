package com.isfinal.controller.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isfinal.base.BaseController;
import com.isfinal.module.model.UserLog;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by wjb on 2019/3/20.
 */
@Controller
public class UserLogSendController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(UserLogSendController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Environment env;
    @Autowired
    private ObjectMapper objectMapper;

    @ResponseBody
    @PostMapping(value = "/user/log")
    public String sendMessage(@RequestParam(value = "name",required = false) String name){
        try {
            if(StringUtils.isNotBlank(name)){
                UserLog userLog = new UserLog();
                userLog.setName("wjb");
                userLog.setPhone(159058136);
                userLog.setCreateTime(new Date());
                rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
                rabbitTemplate.setExchange(env.getProperty("log.user.exchange.name"));
                rabbitTemplate.setRoutingKey(env.getProperty("log.user.routing.key.name"));

                Message message= MessageBuilder.withBody(objectMapper.writeValueAsBytes(userLog)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
//                message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, MessageProperties.CONTENT_TYPE_JSON);
                rabbitTemplate.convertAndSend(message);
                return SUCCESS_FAIL_N(true,"消息发送成功",null);
            }else{
                return SUCCESS_FAIL_N(false,"参数为空",null);
            }
        } catch (Exception e) {
            logger.error("消息发送失败",e);
            return SUCCESS_FAIL_N(false,null,"消息发送失败");
        }
    }


}
