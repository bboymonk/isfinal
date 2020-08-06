package com.isfinal.controller.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isfinal.module.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by wjb on 2019/3/20.
 */
@Component
public class UserLogMqListener {

    private static final Logger logger = LoggerFactory.getLogger(UserLogMqListener.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${log.user.queue.name}",containerFactory = "singleListenerContainer")
    public void consumerUserLogQueue(@Payload byte[] message){
        try {
            UserInfo userLog = objectMapper.readValue(message, UserInfo.class);
            logger.info("监听到的队列消息",userLog);
        } catch (IOException e) {
            logger.error("error ",e);
        }


    }

}
