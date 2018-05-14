package com.hbfintech.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.hbfintech.logger.CustomLogger;
import com.hbfintech.logger.LoggerFactory;

/**
 * 
 * @ClassName:  payConfigApplication   
 * @Description:配置中心
 * @author: zhushuang
 * @date:   2018年4月30日 下午11:48:21   
 *     
 * @Copyright: 2018 www.hbfintech.com Inc. All rights reserved. 
 * 注意：本内容仅限于江苏华博金服控股有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class PayEurekaApplication {
    protected static CustomLogger logger = LoggerFactory.getCustomLogger(PayEurekaApplication.class);
    
    public static void main(String[] args) {
    	new SpringApplicationBuilder(PayEurekaApplication.class).web(true).run(args);
    }
}
