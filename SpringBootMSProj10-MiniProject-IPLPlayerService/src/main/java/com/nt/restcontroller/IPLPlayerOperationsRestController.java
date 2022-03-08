package com.nt.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.IPLPlayerInfo;
import com.nt.service.IPlayerMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/player")
@Slf4j
public class IPLPlayerOperationsRestController {
	@Autowired
	private IPlayerMgmtService service;
	
	@PostMapping("/save")
	public   ResponseEntity<String>   saveIPLPlayer(@RequestBody  IPLPlayerInfo player){
		//use service
		String resultMsg=service.registerPlayer(player);
		log.info("Player  details are saved with id {}"+player.getPid());
		return  ResponseEntity.ok(resultMsg);
		
	}
	
	
	@GetMapping("/all")
	public   ResponseEntity<List<IPLPlayerInfo>>  fetchAllPlayerInfo(){
		//use service
		List<IPLPlayerInfo> list=service.findAllPlayerInfo();
		log.info("Retrieving  All Players Info");
		return  ResponseEntity.ok(list);
	}

}
