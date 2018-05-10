package com.hbfintech.pay.trade.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hbfintech.pay.common.log.SystemLogger;
import com.hbfintech.redis.concurrent.lock.templateLock.TemplateLock;
import com.hbfintech.redis.concurrent.lock.templateLock.TemplateLockImpl;
import com.hbfintech.redis.utils.RedisCacheUtil;
import com.hbfintech.redis.utils.jedis.JedisClient;
import com.hbfintech.redis.utils.jedis.impl.JedisClientImpl;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;


@Configuration
public class RedisConfig {
	
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;
    
    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.pool.max-active}")
    private int maxActive;
    
    @Value("${spring.redis.database}")
    private int database;


    @Bean
	public  JedisPool getJedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxActive);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port,Protocol.DEFAULT_TIMEOUT,null,database);
        SystemLogger.info("-------------JedisPool注入成功！！---------------");
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
