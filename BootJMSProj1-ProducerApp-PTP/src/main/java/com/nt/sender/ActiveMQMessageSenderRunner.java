package com.nt.sender;

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
public class ActiveMQMessageSenderRunner  {
	@Autowired
	private  JmsTemplate  template;

	@Scheduled(cron="*/10 * * * * *")
	public void sendMessage()  {
	//public void run(String... args) throws Exception {
   /*       //using  anonymous inner class logics
		template.send("testmq1", new MessageCreator() {
			@Override
			public Message createMessage(Session ses) throws JMSException {
			        Message message=ses.createTextMessage("From  Sender at ::"+new Date());
				return message;
			}
		}); */
		
	/*  using LAMDA  style anonyomous inner class
	  template.send("testmq1",ses->{
		  return ses.createTextMessage("From sender at"+new Date());
	});*/
		
		//using LAMDA  style anonyomous inner class
		  template.send("testmq1",ses-> ses.createTextMessage("From sender at"+new Date()));
		  System.out.println("Message sent");
	}//run
}//class
