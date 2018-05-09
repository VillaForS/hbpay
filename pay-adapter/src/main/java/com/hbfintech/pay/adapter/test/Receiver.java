package com.hbfintech.pay.adapter.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="testQueue")
public class Receiver {

	@RabbitHandler
	public void process(String msg) {
		System.out.println("--------receive rabbitmq msg:   "+msg);
	}
}
