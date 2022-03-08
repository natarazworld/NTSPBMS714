package com.nt.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.IPLTeamInfo;
import com.nt.service.IIPLTeamMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/team")
@Slf4j
public class IPLTeamOperationsController {
	//private Logger logger=LoggerFactory.getLogger(IPLTeamOperationsController.class);
	@Autowired
	private IIPLTeamMgmtService  service;
	
	@PostMapping("/save")
	public   ResponseEntity<String>  saveIPLTeam(@RequestBody IPLTeamInfo info){
		  String   resultMsg=service.registerIPLTeam(info);
		  log.info("saving IPL Team ");
		  return ResponseEntity.ok(resultMsg);
	}
	
	@GetMapping("/find/{id}")
	public  ResponseEntity<IPLTeamInfo>  fetchTeamInfoById(@PathVariable Integer id){
		    IPLTeamInfo info=service.findIPLTeamDetails(id);
		    System.out.println(info);
		    log.info("Fetching IPL Team  details by id {}"+id);
		    return   ResponseEntity.ok(info);
	}
	
	@GetMapping("/all")
	public  ResponseEntity<List<IPLTeamInfo>>  fetchAllTeamsInfo(){
	         List<IPLTeamInfo>  teamsList=service.findAllIPLTeamDetails();
	         log.info("Fetching All IPL Teams  details ");
	         return  ResponseEntity.ok(teamsList);
	}
 	

}
