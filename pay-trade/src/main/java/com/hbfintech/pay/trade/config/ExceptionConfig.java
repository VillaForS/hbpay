package com.hbfintech.pay.trade.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.hbfintech.pay.trade.Exception.BaseHandlerExceptionResolver;

@Configuration
public class ExceptionConfig {

	public HandlerExceptionResolver getExceptionResolver(){
		return new BaseHandlerExceptionResolver();
	}
}
