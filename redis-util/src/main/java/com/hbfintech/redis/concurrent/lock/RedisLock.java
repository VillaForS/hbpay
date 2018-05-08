package com.hbfintech.redis.concurrent.lock;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.hbfintech.redis.utils.jedis.JedisAction;
import com.hbfintech.redis.utils.jedis.JedisClient;

import redis.clients.jedis.Jedis;


/**
 * 
 * @ClassName:  RedisLock   
 * @Description:Redis锁
 * @author: zhushuang
 * @date:   2018年5月6日 下午9:13:57   
 *     
 * @Copyright: 2018 www.hbfintech.com Inc. All rights reserved. 
 * 注意：本内容仅限于江苏华博金服控股有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class RedisLock {

    private JedisClient jedisClient;
	
	public JedisClient getJedisClient() {
		return jedisClient;
	}

	public void setJedisClient(JedisClient jedisClient) {
		this.jedisClient = jedisClient;
	}

    private final String lockKey;

    private int expireMsecs = 60 * 1000; // 锁超时，防止线程在入锁以后，无限的执行等待

    private int timeoutMsecs = 10 * 1000; // 锁等待，防止线程饥饿

    /**
     * 锁拥有者标识
     */
    private String owner = String.valueOf(System.currentTimeMillis());

    private boolean locked = false;

    private static Random random = new Random();

    public RedisLock(JedisClient redisClient, String lockKey) {
        this.lockKey = lockKey;
    }
    public RedisLock(JedisClient redisClient, String lockKey, int timeoutMsecs) {
        this(redisClient, lockKey);
        this.timeoutMsecs = timeoutMsecs;
    }

    public RedisLock(JedisClient redisClient, String lockKey, int timeoutMsecs, int expireMsecs) {
        this(redisClient, lockKey, timeoutMsecs);
        this.expireMsecs = expireMsecs;
    }
    
    /**
     * @return lock key
     */
    public String getLockKey() {
        return lockKey;
    }

    /**
     * 获取锁
     * 
     * @param jedis
     * @return boolean 
     * @throws InterruptedException
     */
    public synchronized boolean acquire() throws InterruptedException {
        return acquire(this.jedisClient);
    }

    /**
     * 获取锁
     * 
     * @param jedis
     * @return boolean
     * @throws InterruptedException
     */
    public synchronized boolean acquire(JedisClient redisClient) throws InterruptedException {
        int timeout = timeoutMsecs;
        while (timeout >= 0) {
            if ("OK".equals(redisClient.execute(new JedisAction<String>() {
                @Override
                public String doAction(Jedis jedis) {
                	//设置时间，成功设置返回ok,失败返回null
                    return jedis.set(lockKey, owner, "NX", "PX", expireMsecs);
                }
            }))) {
                locked = true;
                return true;
            }

            int sleepTime = random.nextInt(200);
            timeout -= sleepTime;
            Thread.sleep(sleepTime);
        }
        return false;
    }

    /**
     * 释放
     */
    public synchronized void release() {
        release(this.jedisClient);
    }

    /**
     * 释放
     */
    public synchronized void release(JedisClient redisClient) {
        if (locked && owner.equals(redisClient.execute(new JedisAction<String>() {
            @Override
            public String doAction(Jedis jedis) {
                return jedis.get(lockKey);
            }
        }))) {
            redisClient.execute(new JedisAction<Long>() {
                @Override
                public Long doAction(Jedis jedis) {
                    return jedis.del(lockKey);
                }
            });
            locked = false;
        }
    }

}
