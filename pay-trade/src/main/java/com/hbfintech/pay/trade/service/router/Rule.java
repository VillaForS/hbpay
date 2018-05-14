package com.hbfintech.pay.trade.service.router;

import java.util.List;

import com.hbfintech.pay.trade.repository.entity.PayChannel;

public interface Rule
{
      List<PayChannel> execute();
}
