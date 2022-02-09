package com.nt.publisher;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessagePublisher  implements CommandLineRunner {
	@Autowired
	private  JmsTemplate  template;

	@Override
	public void run(String... args) throws Exception {
		//using LAMDA  style anonyomous inner class
		  template.send("topic1",ses-> ses.createTextMessage("From sender at"+new Date()));
		  System.out.println("Message sent/published");
	}//run
}//class
