package com.hbfintech.pay.adapter.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {
	
	@Autowired
	Sender sender;
	
	@GetMapping("/sendMsg")
	public void sendMsg(String msg){
		System.out.println("---------------send Msg---------------");
		  sender.send(msg);
		  return;
	}
	
}
