package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.model.IPLTeamInfo;

@FeignClient("TEAM-SERVICE")
public interface IPLTeamServiceConsumer {
	@GetMapping("/team/find/{id}")
     public  ResponseEntity<IPLTeamInfo>  findIPLTeamById(@PathVariable Integer id);
}
