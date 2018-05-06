package com.hbfintech.pay.trade.test;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbfintech.redis.jedis.utils.RedisCacheUtil;

@RestController
public class HelloController {
	
	@Autowired
	HelloService helloService;

	@Value("${channelNo}")
	private String channelNo;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@Resource(name="stringRedisTemplate")
	ValueOperations<String,String> valOpsStr;
	
	@Autowired
	RedisCacheUtil redisCacheUtil;
	
	@GetMapping("/getChannelNo")
	public String getChannelNo(){
		 return channelNo;
	}
	
	@GetMapping("/cacheTest")
	public String cacheTest(){
		return helloService.get();
	}
	
	@GetMapping("/cacheDelete")
	public void cacheDelete(String s){
		 helloService.delete();
	}
	
	@GetMapping("/saveRedis")
	public void saveRedis(){
		valOpsStr.set("cachekey","handsome");
	}
	
	@GetMapping("/saveObjectToRedis")
	public void saveObjectToRedis(){
		Person person =new Person();
		person.setId("afasdfasf");
		person.setName("zhushuang");
		person.setAge(19);
		redisCacheUtil.setBin("onePerson", person);
	}
}
