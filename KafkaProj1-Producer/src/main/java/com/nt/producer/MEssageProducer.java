package com.nt.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class MEssageProducer {

	public static void main(String[] args) {
		  // create Connection properties  as K=V in java.util.Properties class obj
		 Properties  props=new Properties();
		 props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		 props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		 props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		 //create KafkaProducer  object
		 KafkaProducer<String, String> producer=new KafkaProducer<String, String>(props);
		 //create ProducerRecord object representing the message
		   String  msg="WELcome to Apache kafkas messaging";
		   String topicName="nit-tpc-feb";
		   ProducerRecord<String, String> record=new ProducerRecord<String, String>(topicName, msg);
		 //  Send message (record)
		   producer.send(record);
		   //flush  the message 
		   producer.flush();
		   //close the connection with BootStrap server
		   producer.close();
		   
		   System.out.println("message sent");
	}
}
