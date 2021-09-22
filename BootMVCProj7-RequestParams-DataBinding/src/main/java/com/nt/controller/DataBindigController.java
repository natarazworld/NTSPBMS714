package com.nt.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class DataBindigController {
	
	/*@GetMapping("/data")
	public  String    bindData(Map<String,Object> map,
			                                              @RequestParam("sno") int no , 
			                                              @RequestParam("sname") String name) {
		System.out.println(no+"   "+name);
		//return LVN
		return "show_data";
	}*/
	
	/*@GetMapping("/data")
	public  String    bindData(Map<String,Object> map,
			                                              @RequestParam int sno , 
			                                              @RequestParam(required = false) String sname) {
		System.out.println(sno+"   "+sname);
		//return LVN
		return "show_data";
	}*/
	
	/*@GetMapping("/data")
	public  String    bindData(Map<String,Object> map,
			                                              @RequestParam(defaultValue = "100") int sno , 
			                                              @RequestParam(defaultValue = "raja")  String sname) {
		System.out.println(sno+"   "+sname);
		//return LVN
		return "show_data";
	}*/
	
	/*@GetMapping("/data")
		public  String    bindData(Map<String,Object> map,
				                                              @RequestParam(required = false)  Integer sno , 
				                                              @RequestParam(defaultValue = "raja")  String sname) {
			System.out.println(sno+"   "+sname);
			//return LVN
			return "show_data";
		}*/
	
	/*@GetMapping("/data")
	public  String    bindData(Map<String,Object> map,
			                                              @RequestParam(required = false)  Integer sno , 
			                                              @RequestParam  String[] sname,
			                                              @RequestParam("sname") Set<String> names) {
		System.out.println(sno+"   "+Arrays.toString(sname) +"    "+names);
		//return LVN
		return "show_data";
	}*/
	
	@GetMapping("/data")
	public  String    bindData(Map<String,Object> map,
			                                              @RequestParam(required = false)  Integer sno , 
			                                              @RequestParam  String sname) {
		System.out.println(sno+"   "+sname);
		//return LVN
		return "show_data";
	}

}
