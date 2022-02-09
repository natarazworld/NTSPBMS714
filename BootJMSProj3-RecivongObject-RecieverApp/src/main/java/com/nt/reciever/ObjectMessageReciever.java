package com.nt.reciever;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nt.model.ActorInfo;

@Component
public class ObjectMessageReciever {
	
	@JmsListener(destination = "obj_mq1")
	public   void  consumeObjectDataAsMessage(ActorInfo  actor) {
		  System.out.println("Recived Object Data ::"+actor);
	}
}
