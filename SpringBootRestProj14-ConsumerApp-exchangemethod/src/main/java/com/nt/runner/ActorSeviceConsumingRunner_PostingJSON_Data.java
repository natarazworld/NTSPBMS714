package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorSeviceConsumingRunner_PostingJSON_Data implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//create RestTemplate class object
		RestTemplate  template=new RestTemplate();
		//Define  service url
		 String serviceUrl="http://localhost:3030/SpringBootRestProj14-ProviderApp/actor/register";
		 //prepare JSON data  (request body)
		 String json_body="{ \"aid\" : 1002, \"name\": \"ranveer\" ,\"age\": 30.0 ,\"type\":\"hero\" }";
		 //prepare headers
		 HttpHeaders headers= new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 // prepare  Http request as HttpEntity obj having head , body
		 HttpEntity<String> entity= new HttpEntity<String>(json_body,headers);  //headers + body
		 // make http request call  in post mode
            ResponseEntity<String>  response=template.exchange(serviceUrl, 
            		                                                                                       HttpMethod.POST,
            		                                                                                       entity, 
            		                                                                                       String.class) ; 
		 
		 //display the recieved details from the response
		 System.out.println("Response body(output) ::"+response.getBody());
		 System.out.println("Response headers ::"+response.getHeaders().toString());
		 System.out.println("Response status code value ::"+response.getStatusCodeValue());
		 System.out.println("Response satus code ::"+response.getStatusCode().name());
		 
		 System.out.println("------------------------------------------");

	}

}
