package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo  coronaRepo;

	@Override
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean ascOrder,
			                                                                                                                                                      String... properties) {
		//prepare Example object
		Example example=Example.of(vaccine);
		//prepare Sort object
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,properties);
		List<CoronaVaccine> listEntities=coronaRepo.findAll(example, sort);
		return listEntities;
	}

	@Override
	//@Transactional
	public CoronaVaccine getVaccineByRegNo(Long regNo) {
		return coronaRepo.getById(regNo);
		//return coronaRepo.getOne(regNo);
	}

	@Override
	public String removeVaccinesByRegNos(Iterable<Long> regNos) {
		Iterable<CoronaVaccine> listEntities=coronaRepo.findAllById(regNos);
		if(((List)listEntities).size()!=0) {
			coronaRepo.deleteAllByIdInBatch(regNos);
			return  ((List)listEntities).size()+" no.of records are deleted";
		}
		return  "record not found for deletion"; 
	}

}//class
