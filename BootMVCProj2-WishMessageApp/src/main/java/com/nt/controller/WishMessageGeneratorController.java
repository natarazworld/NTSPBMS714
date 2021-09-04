package com.nt.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessageGeneratorController {
	@Autowired
	private IWishMessageService service;

	@RequestMapping("/")
	public String showHome() {
		return "home"; // LVN
	}

	/*@RequestMapping("/wish")
	public  ModelAndView  generateMessage() {
		 //use service
		String result=service.generateWishMessage();
		//return MAV
		ModelAndView mav=new ModelAndView();
		mav.addObject("wMsg", result);  //Like this we can any no.of model attributes
		mav.setViewName("display");
		return  mav;
		return  new ModelAndView("display","wMsg",result); //Here we can add only one Model Attribute
	}*/
	
	/*	@RequestMapping("/wish")
		public  String  generateMessage(BindingAwareModelMap map) {
			System.out.println("SharedMemory obj class name::"+map.getClass());
			 //use service
			String result=service.generateWishMessage();
			map.addAttribute("wMsg",result);
			//return LVN
			return "display";
				}
	*/	
	
	/*@RequestMapping("/wish")
	public  String  generateMessage(ModelMap map) {
		System.out.println("SharedMemory obj class name::"+map.getClass());
		 //use service
		String result=service.generateWishMessage();
		map.addAttribute("wMsg",result);
		//return LVN
		return "display";
			}*/
	
	/*@RequestMapping("/wish")
	public  String  generateMessage(HashMap<String,Object> map) {
		System.out.println("SharedMemory obj class name::"+map.getClass());
		 //use service
		String result=service.generateWishMessage();
		map.put("wMsg",result);
		//return LVN
		return "display";
			}*/
	
	/*@RequestMapping("/wish")
	public  String  generateMessage(Map<String,Object> map) {
		System.out.println("SharedMemory obj class name::"+map.getClass());
		 //use service
		String result=service.generateWishMessage();
		map.put("wMsg",result);
		//return LVN
		return "display";
			}*/
	
	/*@RequestMapping("/wish")
	public  String  generateMessage(Model model) {
		System.out.println("SharedMemory obj class name::"+model.getClass());
		 //use service
		String result=service.generateWishMessage();
		model.addAttribute("wMsg", result);
		//return LVN
		return "display";
			}*/
	
	/*	@RequestMapping("/wish")
		public  void  generateMessage(Model model) {
			System.out.println("SharedMemory obj class name::"+model.getClass());
			 //use service
			String result=service.generateWishMessage();
			model.addAttribute("wMsg", result);
				}
	*/	
	
	/*@RequestMapping("/wish")
	public  void  generateMessage(Model model) {
		System.out.println("SharedMemory obj class name::"+model.getClass());
		 //use service
		String result=service.generateWishMessage();
		model.addAttribute("wMsg", result);
			}
	*/
	
	/*	@RequestMapping("/wish")
		public  Model  generateMessage() {
			 //use service
			String result=service.generateWishMessage();
			//create model attributes
			  Model model=new ExtendedModelMap();
			  model.addAttribute("wMsg", result);
			  return model;
				}*/
	
	/*@RequestMapping("/wish")
	public Map<String,Object>  generateMessage() {
		 //use service
		String result=service.generateWishMessage();
		//create model attributes
		  Map<String,Object> map=new HashMap();
		  map.put("wMsg", result);
		  return map;
			}*/
	
	@RequestMapping("/wish")
	public void  generateMessage(HttpServletResponse res)throws Exception {
		 //use service
		String result=service.generateWishMessage();
		 // getPrintWriter pointing to response object
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<b>wish message is :: <b> "+result);
		return ;
		  
			}
	
			/*@RequestMapping("/wish")
			public String generateMessage(HttpServletResponse res)throws Exception {
				 //use service
				String result=service.generateWishMessage();
				 // getPrintWriter pointing to response object
				PrintWriter pw=res.getWriter();
				res.setContentType("text/html");
				pw.println("<b>wish message is :: <b> "+result);
				return null ;
				  
					}*/

}
