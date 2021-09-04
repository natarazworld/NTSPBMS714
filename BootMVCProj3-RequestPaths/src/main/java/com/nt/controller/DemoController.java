package com.nt.controller;

import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
	/*@Autowired
	private ServletContext sc;
	@Autowired
	private  ServletConfig cg;
	@Autowired
	private HttpSession ses;*/
		
	@GetMapping(value={"/report"})
	public  String generateReport(Map<String,Object> map,
			                                                    HttpSession ses) {
		System.out.println("DemoController.generateReport(-)");
		System.out.println("Session Id:"+ses.getId());
		return "display";
	}

	
	
}
