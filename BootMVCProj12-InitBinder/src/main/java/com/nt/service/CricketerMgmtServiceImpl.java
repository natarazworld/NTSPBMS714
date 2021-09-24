package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Cricketer;
import com.nt.repository.ICricketerRepo;

@Service
public class CricketerMgmtServiceImpl implements ICricketerMgmtService {
	@Autowired
	private ICricketerRepo  cricketerRepo;

	@Override
	public String registerCricketer(Cricketer cricketer) {
		return "Cricketer is registered with"+cricketerRepo.save(cricketer).getCid(); 
	}

}
