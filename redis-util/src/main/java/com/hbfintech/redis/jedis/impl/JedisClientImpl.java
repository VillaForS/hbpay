/**
 * Copyright (C), 2012-2016, 江苏中地集团有限公司
 * Author:   LG
 * Date:     2016年7月29日 下午4:04:01
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.hbfintech.redis.jedis.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbfintech.redis.jedis.JedisAction;
import com.hbfintech.redis.jedis.JedisClient;
import com.hbfintech.redis.jedis.RedisClientException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisException;

/**
 * 
 * @ClassName:  JedisClientImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: zhushuang
 * @date:   2018年5月6日 下午8:27:41   
 *     
 * @Copyright: 2018 www.hbfintech.com Inc. All rights reserved. 
 * 注意：本内容仅限于江苏华博金服控股有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class JedisClientImpl implements JedisClient {

    private static final Logger logger = LoggerFactory.getLogger(JedisClientImpl.class);
    @Autowired
    private JedisPool jedisPool;
    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    /**
     * 获取redis连接实例
     * @return
     */
    @Override
    public Jedis getJedis() {
        Jedis jedis = null;
        JedisPool jedisPool  = this.getJedisPool();
        try {
            jedis = jedisPool.getResource();
        } catch (JedisException e) {
            logger.error("获取redis连接实例", e);
            if (jedis != null) {
                this.getJedisPool().returnBrokenResource(jedis);
            }
        }
        if (jedis == null) {
        	logger.error("获取redis连接实例", new Throwable("JedisPool is null，Please check redis status!"));
        }
        return jedis;
    }

    /**
     * 扔回到连接池
     */
    @Override
    public void returnResource(Jedis jedis) {

        if (jedis != null) {
            this.getJedisPool().returnResource(jedis);
        }
    }

    @Override
    public <T> T execute(JedisAction<T> action) {
        // 获取业务层面调用execute的类
        T result = null;
        try {
            result = executeAction(action);
        } catch (Exception e) {
            throw new RedisClientException(e);
        }
        return result;
    }

    /**
     * 功能描述: 执行<br>
     * 〈功能详细描述〉
     *
     * @param action
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private <T> T executeAction(JedisAction<T> action) {
        Jedis jedis = null;
        try {
            jedis =this.getJedis();
            return action.doAction(jedis);
        } catch (JedisConnectionException jex) {
            if (jedis != null) {
                try {
                    this.returnResource(jedis);
                } catch (Exception ex) {
                    logger.warn("Can not return broken resource.", ex);
                }
                jedis = null;
            }
            throw jex;
        } finally {
            if (jedis != null) {
                try {
                	this.returnResource(jedis);
                } catch (Exception ex) {
                    logger.warn("Can not return resource.", ex);
                }
            }
        }
    }

}
