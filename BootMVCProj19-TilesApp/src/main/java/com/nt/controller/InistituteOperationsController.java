package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Faculty;
import com.nt.service.ITrainingInstituteMgmtService;

@Controller
public class InistituteOperationsController {
	@Autowired
	private  ITrainingInstituteMgmtService service;
	
	
	@GetMapping("/")
	public    String showHome() {
		 return "homePageDef";
	}
	
	@GetMapping("/list_faculties")
	public  String  showFacultiesPage(Map<String,Object> map) {
		//use service
		Iterable<Faculty> itList=service.getAllFaculties();
		//model attribute
		map.put("facultiesList", itList);
		return "facultiesPageDef";
	}
	
	@GetMapping("/list_courses")
	public  String  showFacultiesPage() {
		return "coursesPageDef";
	}
	
	@GetMapping("/list_traning_modes")
	public  String  showTrainingModesPage() {
		return "trainingPageDef";
	}

}
