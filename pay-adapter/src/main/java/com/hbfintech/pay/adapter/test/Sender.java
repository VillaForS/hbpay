package com.hbfintech.pay.adapter.test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(String msg) {
		rabbitTemplate.convertAndSend(msg);
	}
}
