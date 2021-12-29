package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {
	@Autowired
	 private ITouristMgmtService  service;
	
	@PostMapping("/register")
	public ResponseEntity<String>  enrollTourist(@RequestBody Tourist tourist)throws Exception{
		//use service
		String resultMsg=service.registerTourist(tourist);
		 return  new ResponseEntity<String>(resultMsg,
				                                                                     HttpStatus.CREATED); //201 content created successfully 
				
	}//method
	
	@GetMapping("/findAll")
	public  ResponseEntity<List<Tourist>>  displayToursits() throws Exception{
			 List<Tourist> list=service.fetchAllTourists();
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public  ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id)throws Exception{
		 Tourist  tourist=service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		
	}//method
	
	
	@PutMapping("/modify")
	public   ResponseEntity<String>  modifyTourist(@RequestBody Tourist tourist)throws Exception{
			  String msg=service.updateTouristDetails(tourist);
			  return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String>  removeToursit(@PathVariable("id") Integer id)throws Exception{
		//use service
		String  msg=service.deleteTourist(id);
		 return  new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}//method
	
	
	@PatchMapping("/budgetModify/{id}/{hike}")
	public   ResponseEntity<String>  modifyTouristBudgetById( @PathVariable("id") Integer id,
                                                                                                        @PathVariable("hike") Float  hikePercent)throws Exception{
		//use service
		 String msg=service.updateTouristBudgetById(id, hikePercent);
		 return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}//class
