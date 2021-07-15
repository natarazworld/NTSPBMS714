package com.nt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.repo.ICoronaVaccineRepo;
import com.nt.type.View;

@Service("vaccineMgmtService")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {
	@Autowired
	private ICoronaVaccineRepo  coronaRepo;
	
	@Override
	public <T extends View> List<T> searchVaccinesByCompany(String company, Class<T> clazz) {
		return coronaRepo.findByCompanyOrderByCompanyDesc(company, clazz);
	}
	
}//class
