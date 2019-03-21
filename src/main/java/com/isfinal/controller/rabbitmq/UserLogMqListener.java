package com.isfinal.controller.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isfinal.module.mapper.UserLogMapper;
import com.isfinal.module.model.UserLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
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
    @Autowired
    private UserLogMapper userLogMapper;

    @RabbitListener(queues = "${log.user.queue.name}",containerFactory = "singleListenerContainer")
    public void consumerUserLogQueue(@Payload byte[] message){
        try {
            UserLog userLog = objectMapper.readValue(message, UserLog.class);
            logger.info("监听到的队列消息",userLog);
            userLogMapper.insert(userLog);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
