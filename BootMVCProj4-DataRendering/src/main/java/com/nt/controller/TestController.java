package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Employee;

@Controller
public class TestController {
	
	@GetMapping("/report")
	public  String   showReport(Map<String,Object> map) {
		/*  // add model attributes  (simple values)
		 map.put("name", "raja");
		 map.put("age",40);
		 map.put("addrs", "hyd");*/
		
		/* String nikcNames[]=new String[] {"raja","jani","ramesh","suresh"};
		 Set<Long> mobilePhonesSet=new HashSet();
		 mobilePhonesSet.add(9999999L);mobilePhonesSet.add(8888888L);
		 List<String> coursesList=List.of("java","spring","spring boot","hibernate");
		 Map<String,Long> idsMap=Map.of("aadhar",4543535L,
				                                                               "voterId",53543543534L,
				                                                               "panNo",4545355454L);
		 //create model attribues
		 map.put("nickNames",nikcNames);
		 map.put("phonesInfo",mobilePhonesSet);
		 map.put("coursesInfo",coursesList);
		 map.put("idsInfo",idsMap);*/
		
		/*List<Employee> empsList=List.of(new Employee(101,"Raja","clerk",90000.0),
				                                                         new Employee(102,"Rajesh","developer",190000.0),
				                                                         new Employee(103,"anil","TL",180000.0)
				                                                        );
		map.put("empsInfo", empsList);*/
		
		Employee emp=new Employee(234,"rajesh","TL",66666.0);
		map.put("empInfo",emp);
		 
		
		 //return LVN
		 return "show_report";
		
	}

}
