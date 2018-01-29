package com.isfinal.config.redis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by wjb on 2018/1/29.
 */
@Configuration
public class RedisPoolConfig{
    private static final Logger logger = Logger.getLogger(RedisPoolConfig.class);
    @Value("${redis.host}")
    private String host;

    @Value("${redis.database}")
    private int database;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.timeout}")
    private int timeout;

    @Value("${redis.pool.max-idle}")
    private int maxIdle;

    @Value("${redis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${redis.password}")
    private String password;

    @Bean
    public JedisConnectionFactory redisPoolFactory() {
        logger.info("redis地址：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPoolConfig(jedisPoolConfig);
        factory.setHostName(host);
        factory.setDatabase(database);
        factory.setPort(port);
        return factory;
    }

    @Bean
    public RedisTemplate<String,Object> getRedisTemplate(){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisPoolFactory());
        logger.info("redisTemplate 注入成功");
        return template;
    }

    @Bean
    public StringRedisTemplate getStringRedisTemplate(){
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisPoolFactory());
        logger.info("StringRedisTemplate 注入成功");
        return template;
    }

}