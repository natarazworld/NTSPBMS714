package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorSeviceConsumingRunner_PathVariables implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//create RestTemplate class object
		RestTemplate  template=new RestTemplate();
		//Define  service url
		 String serviceUrl="http://localhost:3030/SpringBootRestProj13-ProviderApp/actor/wish/{id}/{name}";
		 
		 // Generate Http reqeust   with GET mode to consume the web service(API)
		 //ResponseEntity<String> response=template.getForEntity(serviceUrl, String.class,1001,"raja");  (or)
		 ResponseEntity<String> response=template.getForEntity(serviceUrl, String.class,Map.of("name","rajesh","id",1001));
		 //display the recieved details from the response
		 System.out.println("Response body(output) ::"+response.getBody());
		 System.out.println("Response status code value ::"+response.getStatusCodeValue());
		 System.out.println("Response headers ::"+response.getHeaders().toString());
		 System.out.println("Response satus code ::"+response.getStatusCode().name()); 
		 
		 
		 System.exit(0); //optional  .. given for  to stop server automatically

	}

}
