package com.hbfintech.redis.utils.jedis;

import redis.clients.jedis.Jedis;

/**
 * 
 * @ClassName:  JedisAction   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: zhushuang
 * @date:   2018年5月6日 下午8:54:03   
 *   
 * @param <T>  
 * @Copyright: 2018 www.hbfintech.com Inc. All rights reserved. 
 * 注意：本内容仅限于江苏华博金服控股有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface JedisAction<T> {

    public T doAction(Jedis jedis);

}
