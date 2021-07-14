package com.nt.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;
import com.nt.type.ResultView;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo  coronaRepo;
	
	@Override
	public List<ResultView> searchVaccinesByStartPrice(double startPrice) {
		System.out.println(coronaRepo.getClass());
		return coronaRepo.findByPriceGreaterThanEqualOrderByPrice(startPrice);
	}
	
}//class
