//package com.isfinal.config.rabbitmq;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.support.CorrelationData;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//
///**
// * Created by wjb on 2018/12/27.
// */
//@Configuration
//public class RabbitConfig {
//
//    private static final Logger log = LoggerFactory.getLogger(RabbitConfig.class);
//
//    @Autowired
//    private Environment env;
//
//    @Autowired
//    private CachingConnectionFactory cachingConnectionFactory;
//
//    @Autowired
//    private SimpleRabbitListenerContainerFactoryConfigurer configurer;
//
//    /**
//     * 单一消费者
//     */
//    @Bean(name = "singleListenerContainer")
//    public SimpleRabbitListenerContainerFactory listenerContainer(){
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(cachingConnectionFactory);
//        factory.setMessageConverter(new Jackson2JsonMessageConverter());
//        factory.setConcurrentConsumers(1);
//        factory.setMaxConcurrentConsumers(1);
//        factory.setPrefetchCount(1);
//        factory.setTxSize(1);
////        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
//        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        return factory;
//    }
//
//    /**
//     * 多个消费者
//     * @return
//     */
//    @Bean(name = "multiListenerContainer")
//    public SimpleRabbitListenerContainerFactory multiListenerContainer(){
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        configurer.configure(factory,cachingConnectionFactory);
//        factory.setMessageConverter(new Jackson2JsonMessageConverter());
//        factory.setAcknowledgeMode(AcknowledgeMode.NONE);
//        factory.setConcurrentConsumers(env.getProperty("spring.rabbitmq.listener.simple.concurrency",int.class));
//        factory.setMaxConcurrentConsumers(env.getProperty("spring.rabbitmq.listener.simple.max-concurrency",int.class));
//        factory.setPrefetchCount(env.getProperty("spring.rabbitmq.listener.simple.prefetch",int.class));
//        return factory;
//    }
//
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(){
//        cachingConnectionFactory.setPublisherConfirms(true);
//        cachingConnectionFactory.setPublisherReturns(true);
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
//        rabbitTemplate.setMandatory(true);
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> log.info("消息发送成功:correlationData({}),ack({}),cause({})",correlationData,ack,cause));
//        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
//            @Override
//            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//                log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}",exchange,routingKey,replyCode,replyText,message);
//            }
//        });
//        return rabbitTemplate;
//    }
//
//
//    /**
//     *
//     * 用户操作日志消息模型
//     */
//    @Bean
//    public DirectExchange logUserExchange(){
//        return new DirectExchange(env.getProperty("log.user.exchange.name"),true,false);
//    }
//
//    @Bean
//    public Binding logUserBinding(){
//        return BindingBuilder.bind(logUserQueue()).to(logUserExchange()).with("log.user.routing.key.name");
//    }
//
//
//    @Bean
//    public Queue logUserQueue(){
//        return new Queue(env.getProperty("log.user.queue.name"),true);
//    }
//
//}
