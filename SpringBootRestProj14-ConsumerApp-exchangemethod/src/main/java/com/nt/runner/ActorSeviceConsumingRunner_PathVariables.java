package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
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
				 String serviceUrl="http://localhost:3030/SpringBootRestProj14-ProviderApp/actor/wish/{id}/{name}";
				 
				 //  invoke  service method/operation using exchange(-,-,-) method
				 ResponseEntity<String>  resp=template.exchange(serviceUrl,
						                                                                                HttpMethod.GET, 
						                                                                                null,  // no  body for GET moode request and  we do not want to pass 
						                                                                                              //any header values
						                                                                                String.class,  //required type
						                                                                                7890, "anitha");  //path or uri variable values
				 //  display the details
				 System.out.println("response body (output)::"+resp.getBody());
				 System.out.println("response status code ::"+resp.getStatusCode());
				 System.out.println("response status code value ::"+resp.getStatusCodeValue());
				 System.out.println("response header values ::"+resp.getHeaders());
				 
				System.out.println("-------------------------------------------------"); 
				 
				

	}

}
