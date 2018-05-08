package com.hbfintech.redis.concurrent.lock.templateLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hbfintech.redis.concurrent.constants.LockBeanKeyConstants;
import com.hbfintech.redis.concurrent.lock.RedisLock;
import com.hbfintech.redis.utils.jedis.JedisClient;


/**
 * 并发业务处理模版默认redis实现<br>
 * 在redis中使用Key-Value的形式记录，在处理前对锁状态进行判断
 * redis中的Key： Key前缀:锁类型:锁ID:方法<br>
 * @author zhushuang
 */
public class TemplateLockImpl implements TemplateLock {
	private static final Logger logger = LoggerFactory.getLogger(TemplateLockImpl.class);
	
	@Autowired
    JedisClient jedisClient;

    /**
     * 默认排队时间长度，10秒
     */
    private static final int DEFAULT_TIME_OUT_MSECS = 10000;

    /**
     * 默认锁时间长度，600秒
     */
    private static final int DEFAULT_EXPIRE_MSECS = 600000;

    /**
     * 功能描述: 如果存在并发，则等待第一个执行完
     *
     * @param lockBean
     * @param callBack
     * @return T
     */
    public <T> T execute(LockBean lockBean, CallBack<T> callBack) {
        return execute(lockBean, Boolean.TRUE, DEFAULT_TIME_OUT_MSECS, DEFAULT_EXPIRE_MSECS, callBack);
    }

    /**
     * 
     * 功能描述: 如果存在并发，则抛异常，不等待
     *
     * @param lockBean
     * @param callBack
     * @return T
     */
    @Override
    public <T> T executeNoWait(LockBean lockBean, CallBack<T> callBack) {
        return execute(lockBean, Boolean.FALSE, DEFAULT_TIME_OUT_MSECS, DEFAULT_EXPIRE_MSECS, callBack);
    }
    
    /**
     * 
     * 功能描述: 如果存在并发，则抛异常，不等待
     *
     * @param lockBean
     * @param expireMsecs 缓存有效时间
     * @param callBack
     * @return T
     */
    @Override
	public <T> T executeNoWait(LockBean lockBean, int expireMsecs, CallBack<T> callBack) {
    	return execute(lockBean, Boolean.FALSE, DEFAULT_TIME_OUT_MSECS, expireMsecs, callBack);
	}

    public <T> T execute(LockBean lockBean, boolean waitInQueue, int timeoutMsecs, int expireMsecs, CallBack<T> callBack) {
        int timeoutMsecsTemp = DEFAULT_TIME_OUT_MSECS;
        int expireMsecsTemp = DEFAULT_EXPIRE_MSECS;
        // 需要排队
        if (waitInQueue) {
            // timeoutMsecs小于等于零，默认排队10秒
            if (timeoutMsecs <= 0) {
                timeoutMsecsTemp = DEFAULT_TIME_OUT_MSECS;
            } else {
                timeoutMsecsTemp = timeoutMsecs;
            }

            // 不需要排队
        } else {
            timeoutMsecsTemp = 0;
        }

        // expireMsecs小于等于零时，默认有效期60秒
        if (expireMsecs <= 0) {
            expireMsecsTemp = DEFAULT_EXPIRE_MSECS;
        } else {
            expireMsecsTemp = expireMsecs;
        }

        return invoke(lockBean, timeoutMsecsTemp, expireMsecsTemp, callBack);
    }

    /**
     * 回调前置
     * 
     * @param <T>
     * 
     * @param lockBean 并发处理记录
     */
    private <T> T invoke(final LockBean lockBean, final int timeoutMsecs, final int expireMsecs, CallBack<T> callBack) {
        final String key = LockBeanKeyConstants.REDIS_LOCKBEAN_PREFIX + lockBean.getlockType() + ":" + lockBean.getlockId()+":"+lockBean.getMethod();
        RedisLock jedisLock = new RedisLock(jedisClient, key, timeoutMsecs, expireMsecs);
        try {
            if (jedisLock.acquire()) { // 启用锁
                return callBack.invoke();
            } else {
            	logger.error("并发执行异常：", "lockType：" + lockBean.getlockType() + "，lockId：" + lockBean.getlockId()+"，method："+lockBean.getMethod() + "，并发执行！");
                throw new RuntimeException("业务处理中,请稍候...");
            }
        } catch (InterruptedException e) {
        	logger.error("并发执行异常",e);
            throw new RuntimeException(e.getMessage());
        } finally {
        	jedisLock.release();
        }
    }

}
