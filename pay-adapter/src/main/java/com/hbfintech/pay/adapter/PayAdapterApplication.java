package com.hbfintech.pay.adapter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.hbfintech.logger.CustomLogger;
import com.hbfintech.logger.LoggerFactory;

@SpringBootApplication
@EnableDiscoveryClient
public class PayAdapterApplication {

    protected static CustomLogger logger = LoggerFactory.getCustomLogger(PayAdapterApplication.class);
    
	public static void main(String[] args) {
		new SpringApplicationBuilder(PayAdapterApplication.class).web(true).run(args);
	}

}
