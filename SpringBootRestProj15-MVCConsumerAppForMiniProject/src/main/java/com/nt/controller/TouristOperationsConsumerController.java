package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.entity.Tourist;

@Controller
public class TouristOperationsConsumerController {
	@Autowired
	private  RestTemplate  template;
	
	@GetMapping("/")
	public String  showHome() {
		return "home";  //LVN
	}
	
	@GetMapping("/list_tourists")
	public  String   diplayTouristsReport(Map<String,Object> map)throws Exception{
		//consume   SpringRest Service/method/operation
		 /*  url/uri ::  http://localhost:3030/SpringBootRestProj11-MiniProject-ExceptionHandler/tourist/findAll
		  *  method ::  GET
		  *  response  Content type :: applicaiton/json (default)
		  *  No path variables/ No Query String
		  *  No  headers, body required
		  */
		  String serviceUrl="http://localhost:3030/SpringBootRestProj11-MiniProject-ExceptionHandler/tourist/findAll";
		  ResponseEntity<String> resp=template.exchange(serviceUrl,
				                                                                                HttpMethod.GET, 
				                                                                                null, String.class );
		  String jsonRespBody=resp.getBody();
		  // convert String json response body to  List<Tourist> (List of Model objs)
		  ObjectMapper mapper=new ObjectMapper();
		    List<Tourist> touristsList=mapper.readValue(jsonRespBody, new TypeReference<List<Tourist>>() {	});
		    // keep  results in Map collection as Model attributes
		    map.put("touristList", touristsList);
		    //return LVN
		    return  "tourist_report";
		  
	}
	
	@GetMapping("/add")   //To launch form page
	public    String    showRegisterTouristForm(@ModelAttribute("tst")Tourist tourist) {
		   return  "add_tourist";
	}
	
	@PostMapping("/add")
	public    String  registerTourist(RedirectAttributes attrs, @ModelAttribute("tst") Tourist  tourist)throws Exception {
		//convert   object to JSON  data using  jackson api
		 ObjectMapper mapper=new ObjectMapper();
		 String jsonData=mapper.writeValueAsString(tourist);
		// invoke  spring Rest service
		 String serviceUrl="http://localhost:3030/SpringBootRestProj11-MiniProject-ExceptionHandler/tourist/register";
		 // prepare HttpEntity object (headers +body)
		 HttpHeaders headers=new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<String> entity=new HttpEntity<String>(jsonData, headers);
		  ResponseEntity<String> resp=template.exchange(serviceUrl,
				                                                                                HttpMethod.POST, 
				                                                                                entity, String.class );
		  String result=resp.getBody();
		  attrs.addFlashAttribute("resultMsg",result);
		return "redirect:list_tourists";
	}
	
	@GetMapping("/edit")
	public  String    showEditFormPage(@RequestParam("id") Integer mid,
			                                                        @ModelAttribute("tst") Tourist  tourist) throws Exception {
		//invoke spring Rest Srevice
		 String serviceUrl="http://localhost:3030/SpringBootRestProj11-MiniProject-ExceptionHandler/tourist/find/{id}";
		 ResponseEntity<String> resp=template.exchange(serviceUrl,
                 HttpMethod.GET, 
                 null, String.class,
                 mid);
		 // get json body from response
		 String jsonBody=resp.getBody();
		 //convert jsonBody to  Tourist object  using ObjectMapper
		 ObjectMapper mapper=new ObjectMapper();
		  Tourist tourist1=mapper.readValue(jsonBody, Tourist.class);
		  BeanUtils.copyProperties(tourist1, tourist);
		return  "edit_tourist";
	}
	
	@PostMapping("/edit")
	public  String   editTourist(RedirectAttributes attrs,
			                                     @ModelAttribute("tst") Tourist tourist)throws Exception{
		//convert   object to JSON  data using  jackson api
		 ObjectMapper mapper=new ObjectMapper();
		 String jsonData=mapper.writeValueAsString(tourist);
		// invoke  spring Rest service
		 String serviceUrl="http://localhost:3030/SpringBootRestProj11-MiniProject-ExceptionHandler/tourist/modify";
		 // prepare HttpEntity object (headers +body)
		 HttpHeaders headers=new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<String> entity=new HttpEntity<String>(jsonData, headers);
		                              //template.put(serviceUrl, entity);
		  ResponseEntity<String> resp=template.exchange(serviceUrl,
				                                                                                HttpMethod.PUT, 
				                                                                                entity, String.class ); 
		  String result=resp.getBody();
		  attrs.addFlashAttribute("resultMsg",result);
		return "redirect:list_tourists";
	}

}
