package com.nt.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class MessageConsumer {

	public static void main(String[] args) {
		  // create Connection properties  as K=V in java.util.Properties class obj
		 Properties  props=new Properties();
		 props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		 props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		 props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		 props.put(ConsumerConfig.GROUP_ID_CONFIG,"grp1_consumers");
		 //create KafkaConsumer  object
		 KafkaConsumer<String, String> consumer=new KafkaConsumer<String, String>(props);
		 //Subscribe to  topic  Destination through  MEssagebroker
		    consumer.subscribe(Arrays.asList("nit-tpc-feb"));
		  //Performing polling to check and read the messages
		    while(true) {
		    	  //poll and get consumer records (messages)
		    	ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(2000));
		    	 // read  and display messages
		    	   for(ConsumerRecord<String,String> record:records) {
		    		      System.out.println("message is ::"+record.value());
		    	   }//for
		    }//while
	}
}
