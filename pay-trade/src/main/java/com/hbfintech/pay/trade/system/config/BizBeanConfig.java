package com.hbfintech.pay.trade.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hbfintech.redis.sequence.utils.SequenceNoService;

@Configuration
public class BizBeanConfig {

	@Bean
	SequenceNoService getSequenceNoService(){
		return new SequenceNoService();
	}
}
