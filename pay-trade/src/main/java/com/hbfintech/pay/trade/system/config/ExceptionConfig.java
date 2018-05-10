package com.hbfintech.pay.trade.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.hbfintech.pay.trade.system.exception.BaseHandlerExceptionResolver;

@Configuration
public class ExceptionConfig {

	public HandlerExceptionResolver getExceptionResolver(){
		return new BaseHandlerExceptionResolver();
	}
}
