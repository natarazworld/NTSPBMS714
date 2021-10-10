package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Faculty;
import com.nt.repository.IFacultyRepo;

@Service("traningMgmtService")
public class TrainingInstituteMgmtServiceImpl implements ITrainingInstituteMgmtService {
	@Autowired
	private  IFacultyRepo  facultyRepo;

	@Override
	public Iterable<Faculty> getAllFaculties() {
		return  facultyRepo.findAll();
	}

}
