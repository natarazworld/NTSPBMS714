package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.UserDetails;
import com.nt.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	  @Autowired
	   private IUserService service;
	  
	  @GetMapping("/register")  //for form launching
	  public  String showUserRegisterForm(@ModelAttribute("userInfo") UserDetails details) {
		 System.out.println("UserController.showUserRegisterForm()");
		  return "user_register";
	  }
	  
	  
	  @PostMapping("/register")
	  public  String  registerUser(Map<String,Object> map,
			                                                @ModelAttribute("userInfo") UserDetails details) {
		  System.out.println("UserController.registerUser()");
		  //use service
		  String resultMsg=service.register(details);
		  map.put("message", resultMsg);
		  //return LVN
		  return "user_registered_success";
		  
	  }
	  
	  
	  @RequestMapping("/showLogin")
	  public String   showLoginPage() {
		   return  "custom_login";
	  }
	  
	  

}
