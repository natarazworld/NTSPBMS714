package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	//@RequestMapping("/")
	//@RequestMapping
	@GetMapping
	public   String  showHome() {
		System.out.println("TestController.showHome()");
		return "home";
	}
	
	/*	@PostMapping
		public   String  showHome1() {
			System.out.println("TestController.showHome1()");
			return "home";
		}*/
	
	/*	//@RequestMapping(value="/report",method = RequestMethod.GET)
		@GetMapping(value={"/report","/report1","/report2"})
		public  String showReport(Map<String,Object> map) {
			System.out.println("TestController.showReport(-)");
			return "display";
		}*/
	
	/*	//@RequestMapping(value="/report",method = RequestMethod.POST)
		@PostMapping("/report")
		public  String showReport1(Map<String,Object> map) {
			System.out.println("TestController.showReport1(-)");
			return "display1";
		}
	*/
	
		
	@GetMapping(value={"/report"})
	public  String showReport(Map<String,Object> map) {
		System.out.println("TestController.showReport(-)");
		return "display";
	}

	
	
}
