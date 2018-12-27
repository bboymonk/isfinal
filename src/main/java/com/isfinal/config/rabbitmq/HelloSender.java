package com.isfinal.config.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by wjb on 2018/12/27.
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + System.currentTimeMillis();
        System.out.println("Sender ====== " + context);
        rabbitTemplate.convertAndSend("hello", context);
    }


}
