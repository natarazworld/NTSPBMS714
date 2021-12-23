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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tourist")
@Api("All about tourists")
public class TouristOperationsController {
	@Autowired
	 private ITouristMgmtService  service;
	
	@PostMapping("/register")
	@ApiOperation("For Tourist registration")
	public ResponseEntity<String>  enrollTourist(@RequestBody Tourist tourist){
		try {
		//use service
		String resultMsg=service.registerTourist(tourist);
		 return  new ResponseEntity<String>(resultMsg,
				                                                                     HttpStatus.CREATED); //201 content created successfully 
		}
		catch(Exception e) {
			e.printStackTrace();
			return  new ResponseEntity<String>("problem in tourist enrollment",
                    HttpStatus.INTERNAL_SERVER_ERROR); //500 error
		}
		
	}//method
	
	@GetMapping("/findAll")
	public  ResponseEntity<?>  displayToursits(){
		try {
			 List<Tourist> list=service.fetchAllTourists();
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return  new  ResponseEntity<String>("Problem in fetching  Tourists",
					                                                                  HttpStatus.INTERNAL_SERVER_ERROR); //500 eror
		}
	}
	
	@GetMapping("/find/{id}")
	public  ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id){
		try {
			 Tourist  tourist=service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), 
					                                                                     HttpStatus.INTERNAL_SERVER_ERROR); //500
		}
		
	}//method
	
	
	@PutMapping("/modify")
	public   ResponseEntity<String>  modifyTourist(@RequestBody Tourist tourist){
		  try {
			  String msg=service.updateTouristDetails(tourist);
			  return new ResponseEntity<String>(msg,HttpStatus.OK);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
			  return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		  }
		
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String>  removeToursit(@PathVariable("id") Integer id){
		try {
		//use service
		String  msg=service.deleteTourist(id);
		 return  new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return  new ResponseEntity<String>(e.getMessage(),
					                                                                HttpStatus.NOT_FOUND);
		}
		
	}//method
	
	
	@PatchMapping("/budgetModify/{id}/{hike}")
	public   ResponseEntity<String>  modifyTouristBudgetById(@PathVariable("id") Integer id,
			                                                                                                           @PathVariable("hike") Float  hikePercent){
       try {
		//use service
		 String msg=service.updateTouristBudgetById(id, hikePercent);
		 return new ResponseEntity<String>(msg,HttpStatus.OK);
        }//try
       catch(Exception e) {
    	   e.printStackTrace();
    	   return new  ResponseEntity<String>(e.getMessage(),
    			                                                                    HttpStatus.NOT_FOUND);
       }
		
	}

}//class
