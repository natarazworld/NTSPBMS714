package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MarriageSeekerInfo;
import com.nt.repository.IMarriageSeekerInfoRepo;

@Service("matrimonyService")
public class MatrimonyMgmtServiceImpl implements IMatrimonyMgmtService {
	@Autowired
	private  IMarriageSeekerInfoRepo seekerRepo;

	@Override
	public String registerProfile(MarriageSeekerInfo entity) {
	     return  "Profile is registered with Id:: "+seekerRepo.save(entity).getProfileId();	
	}
	
	@Override
	public Iterable<MarriageSeekerInfo> getAllProfiles() {
		return seekerRepo.findAll();
	}
	

}
