package com.hbfintech.redis.concurrent.lock.templateLock;

/**
 *	回调接口
 * @param <T>
 * @author zhushuang
 */
public interface CallBack<T> {
    /**
     * 回调方法
     * @return T
     */
    T invoke();
}
