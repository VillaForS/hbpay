package com.hbfintech.pay.trade.service.router;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hbfintech.pay.trade.repository.entity.PayChannel;

/**
 * 
 * 渠道银行受理能力规则
 *
 * @author zhush
 * @since 1.0
 */
@Component
public class ChannelSupportBankRule implements Rule
{

    @Override
    public List<PayChannel> execute()
    {
        // TODO Auto-generated method stub
        return null;
    }
        
}
