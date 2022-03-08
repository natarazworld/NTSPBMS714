package com.nt.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.IPLTeamInfo;
import com.nt.repository.IIPLTeamInfoRepo;

@Service
public class IPLTeamMgmtServiceImpl implements IIPLTeamMgmtService {
	private Logger logger=LoggerFactory.getLogger(IPLTeamMgmtServiceImpl.class);
	@Autowired
	private IIPLTeamInfoRepo  teamRepo;

	@Override
	public String registerIPLTeam(IPLTeamInfo info) {
		int idVal=teamRepo.save(info).getTeamId();
		logger.info("IPL Team is registered sucessfully with id {}"+idVal);
		return "Team is registered with id :"+idVal; 
	}

	@Override
	public IPLTeamInfo findIPLTeamDetails(int teamId) {
		logger.info("Getting  IPLTeam info by id {}"+teamId);
		return teamRepo.findById(teamId).get();
	}

	@Override
	public List<IPLTeamInfo> findAllIPLTeamDetails() {
		logger.info("Getting  all IPL Team details ");
		return teamRepo.findAll();
	}

}
