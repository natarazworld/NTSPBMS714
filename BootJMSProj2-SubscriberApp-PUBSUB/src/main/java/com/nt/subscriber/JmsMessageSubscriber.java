package com.nt.subscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageSubscriber {
	
	@JmsListener(destination = "topic1")
	public    void  readMessage(String text) {
		 System.out.println("Recived Message::"+text);
	}

}
