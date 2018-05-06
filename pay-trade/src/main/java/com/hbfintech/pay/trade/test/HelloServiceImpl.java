package com.hbfintech.pay.trade.test;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{

	
	@Override
	@Cacheable(value="hbPay")
	public String get() {
		// TODO Auto-generated method stub
		System.out.println("---------------get from method-----------");
		return "zhushushunag";
	}

	@Override
	@CacheEvict(value="hbPay")
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("---------------delete from method-----------");
	}

}
