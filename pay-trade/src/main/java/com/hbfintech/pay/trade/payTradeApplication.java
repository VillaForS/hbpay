package com.hbfintech.pay.trade;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
 * @ClassName:  payTradeApplication   
 * @Description:交易中心
 * @author: zhushuang
 * @date:   2018年5月1日 上午12:26:48   
 *     
 * @Copyright: 2018 www.hbfintech.com Inc. All rights reserved. 
 * 注意：本内容仅限于江苏华博金服控股有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
public class payTradeApplication {
    public static void main(String[] args) {
    	new SpringApplicationBuilder(payTradeApplication.class).web(true).run(args);
    }
}
