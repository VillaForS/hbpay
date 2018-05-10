package com.hbfintech.pay.trade.system.config.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

import com.hbfintech.pay.common.log.SystemLogger;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author kaylves
 * @since 1.0
 */
public class ExecutorCondition implements Condition
{
    private static final String TASK_CUSTOM_EXECUTOR = "task.custom.executor";

    
    @Override
    public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata)
    {
        String executor = context.getEnvironment().getProperty(TASK_CUSTOM_EXECUTOR);
        if(StringUtils.isEmpty(executor))
        {
        	SystemLogger.info("------------AsynExecutor not loaded ,No task.custom.executor properties found");
        }
        
        return !StringUtils.isEmpty(executor);
    }

}
