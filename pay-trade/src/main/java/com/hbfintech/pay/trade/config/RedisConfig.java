package com.hbfintech.pay.trade.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hbfintech.redis.concurrent.lock.templateLock.TemplateLock;
import com.hbfintech.redis.concurrent.lock.templateLock.TemplateLockImpl;
import com.hbfintech.redis.jedis.JedisClient;
import com.hbfintech.redis.jedis.impl.JedisClientImpl;
import com.hbfintech.redis.jedis.utils.RedisCacheUtil;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


@Configuration
public class RedisConfig {
	
	Logger logger = LoggerFactory.getLogger(RedisConfig.class);
	
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.max-wait}")
    private long maxWaitMillis;


    @Bean
	public  JedisPool getJedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, null);
        logger.info("JedisPool注入成功！！");
        return jedisPool;
	}
    
    @Bean
    public JedisClient getJedisClient(){
    	return new JedisClientImpl();
    }
    
    @Bean
    public RedisCacheUtil getRedisCacheUtil(){
    	return new RedisCacheUtil();
    }
    
    @Bean
    public TemplateLock getTemplateLock(){
    	return new TemplateLockImpl();
    }
}
