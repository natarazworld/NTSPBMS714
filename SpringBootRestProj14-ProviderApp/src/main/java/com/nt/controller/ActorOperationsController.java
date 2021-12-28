package com.nt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;

@RestController
@RequestMapping("/actor")
public class ActorOperationsController {
	
	@GetMapping("/wish")
	public  ResponseEntity<String>  displayWishMessage(){
		return  new ResponseEntity<String>("Good Morning",HttpStatus.OK);
	}
	
	@GetMapping("/wish/{id}/{name}")
	public  ResponseEntity<String>  displayWishMessage(@PathVariable Integer id,
			                                                                                    @PathVariable  String name){
		return  new ResponseEntity<String>("Good Morning::"+id+"..."+name,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public  ResponseEntity<String>  registerActor(@RequestBody Actor actor){
		return  new ResponseEntity<String>("Actor data"+actor.toString(),HttpStatus.OK);
	}
	
	@GetMapping("/find")
	public   ResponseEntity<Actor>   searchActor( ){
		return new ResponseEntity<Actor>(new Actor(200,"salman",56.0f,"hero"),  //body
				                                                      HttpStatus.OK);  // status code
	}
	
	@GetMapping("/findAll")
	public   ResponseEntity<List<Actor>>  fetchAllActors(){
		 return new  ResponseEntity<List<Actor>>(List.of(new Actor(101,"salman",55.0f,"hero"),
				                                                                  new Actor(102,"rajesh",65.0f,"hero"),
				                                                                  new Actor(103,"ranveer",35.0f,"hero")),
				                                                                 HttpStatus.OK);
	}

}
