package com.hbfintech.pay.trade.system.config.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

import com.hbfintech.logger.CustomLogger;
import com.hbfintech.logger.LoggerFactory;
import com.hbfintech.pay.trade.PayTradeApplication;


public class ExecutorCondition implements Condition
{
    protected static CustomLogger logger = LoggerFactory.getCustomLogger(PayTradeApplication.class);
    
    private static final String TASK_CUSTOM_EXECUTOR = "task.custom.executor";

    
    @Override
    public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata)
    {
        String executor = context.getEnvironment().getProperty(TASK_CUSTOM_EXECUTOR);
        return !StringUtils.isEmpty(executor);
    }

}
