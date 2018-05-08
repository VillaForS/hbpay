package com.hbfintech.pay.trade.config;


import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.hbfintech.pay.trade.config.condition.ExecutorCondition;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author kaylves
 * @since 1.0
 */
@Configuration
@EnableAsync
public class ExecutorConfig
{
    /** Set the ThreadPoolExecutor's core pool size. */
	
	@Value("${task.custom.executor.corePoolSize:1}")
    private Integer corePoolSize;

    /** Set the ThreadPoolExecutor's maximum pool size. */
	@Value("${task.custom.executor.maxPoolSize:1}")
    private Integer maxPoolSize;

    /** Set the capacity for the ThreadPoolExecutor's BlockingQueue. */
	@Value("${task.custom.executor.queueCapacity:1}")
    private Integer queueCapacity;
    
    @Bean
    @Conditional(ExecutorCondition.class)
    public Executor executor()
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }

    public void setCorePoolSize(int corePoolSize)
    {
        this.corePoolSize = corePoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize)
    {
        this.maxPoolSize = maxPoolSize;
    }

    public void setQueueCapacity(int queueCapacity)
    {
        this.queueCapacity = queueCapacity;
    }

}
