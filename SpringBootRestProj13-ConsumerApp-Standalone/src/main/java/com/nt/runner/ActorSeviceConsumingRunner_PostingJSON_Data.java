package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorSeviceConsumingRunner_PostingJSON_Data implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//create RestTemplate class object
		RestTemplate  template=new RestTemplate();
		//Define  service url
		 String serviceUrl="http://localhost:3030/SpringBootRestProj13-ProviderApp/actor/register";
		 //prepare JSON data  (request body)
		 String json_body="{ \"aid\" : 1001, \"name\": \"suresh\" ,\"age\": 30.0 ,\"type\":\"hero\" }";
		 //prepare headers
		 HttpHeaders headers= new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 // prepare  Http request as HttpEntity obj having head , body
		 HttpEntity<String> request= new HttpEntity<String>(json_body,headers);
		 // make http request call  in post mode
            ResponseEntity<String>  response=template.postForEntity(serviceUrl,request,String.class);  //url,request, output type  
		 
		 //display the recieved details from the response
		 System.out.println("Response body(output) ::"+response.getBody());
		 System.out.println("Response headers ::"+response.getHeaders().toString());
		 System.out.println("Response status code value ::"+response.getStatusCodeValue());
		 System.out.println("Response satus code ::"+response.getStatusCode().name()); 
		 
		 
		 System.exit(0); //optional  .. given for  to stop server automatically

	}

}
