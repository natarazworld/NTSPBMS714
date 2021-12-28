package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;

@Component
public class ActorSeviceConsuming_GettingJSONData_Runner implements CommandLineRunner {
	

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorSeviceConsuming_GettingJSONData_Runner.run()");
		//create RestTemplate class object
		RestTemplate  template=new RestTemplate();
		//Define  service url
		 String serviceUrl="http://localhost:3030/SpringBootRestProj14-ProviderApp/actor/find";
		 
		 //  invoke  service method/operation using exchange(-,-,-) method
		 ResponseEntity<String>  resp=template.exchange(serviceUrl,
				                                                                                HttpMethod.GET, 
				                                                                                null,  // no  body for GET moode request and  we do not want to pass 
				                                                                                              //any header values
				                                                                                String.class);
		 //  display the details
		 System.out.println("response body (json output)::"+resp.getBody());
		 System.out.println("response status code ::"+resp.getStatusCode());
		 System.out.println("response status code value ::"+resp.getStatusCodeValue());
		 System.out.println("response header values ::"+resp.getHeaders());
		 
		 
		 System.out.println("------------------------------------");
		 
		 //converting JSON text response(body) to  Java class object /Model class obj/Entity class object using JACKSON api
		  String jsonBody=resp.getBody();
		  //create ObjectMapper 
		  ObjectMapper mapper=new ObjectMapper();
		  Actor actor=mapper.readValue(jsonBody,   // body
				                           Actor.class);  //required object type
		  System.out.println("response body as the Actor object data:: "+actor);
		  System.out.println("====================================================");
		  
		//Define  service url
			  serviceUrl="http://localhost:3030/SpringBootRestProj14-ProviderApp/actor/findAll";
			//  invoke  service method/operation using exchange(-,-,-) method
				 ResponseEntity<String>  resp1=template.exchange(serviceUrl,
						                                                                                HttpMethod.GET, 
						                                                                                null,  // no  body for GET moode request and  we do not want to pass 
						                                                                                              //any header values
						                                                                                String.class);
				 //  display the details
				 System.out.println("response body (json output)::"+resp1.getBody());
				 System.out.println("response status code ::"+resp1.getStatusCode());
				 System.out.println("response status code value ::"+resp1.getStatusCodeValue());
				 System.out.println("response header values ::"+resp1.getHeaders());
				 //converting JSON text response(body) to  Java class object /Model class obj/Entity class object using JACKSON api
				  String jsonBody1=resp1.getBody();
				  //create ObjectMapper 
				  ObjectMapper mapper1=new ObjectMapper();
				  Actor[] actors=mapper1.readValue(jsonBody1,   // body
						                                                                       Actor[].class);  //required object type
				  List<Actor> listActors=Arrays.asList(actors);
				  System.out.println("response body as the List<Actor> object's data:: "+listActors);
				  System.out.println("----------------------------");
				  listActors.forEach(System.out::println);
				  System.out.println("----------------------------------");
				  List<Actor> listActors1=mapper1.readValue(jsonBody1,new TypeReference<List<Actor>>() {});
				  System.out.println("----------------------------");
				  listActors1.forEach(System.out::println);

	}//method
}//class
