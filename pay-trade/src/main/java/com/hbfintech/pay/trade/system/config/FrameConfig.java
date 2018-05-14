package com.hbfintech.pay.trade.system.config;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.hbfintech.pay.trade.system.exception.BaseHandlerExceptionResolver;

@Configuration
public class FrameConfig {

	@Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                .configure()
                .addProperty( "hibernate.validator.fail_fast", "true" )
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        return validator;
    }
	
   @Bean
   public HandlerExceptionResolver getExceptionResolver(){
        return new BaseHandlerExceptionResolver();
    }
   
   @Bean
   public RestTemplate getRestTemplate() {
       return new RestTemplate();
   }
}
