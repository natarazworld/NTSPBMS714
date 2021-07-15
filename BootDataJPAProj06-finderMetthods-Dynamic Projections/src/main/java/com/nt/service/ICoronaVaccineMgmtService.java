package com.nt.service;

import java.util.List;

import com.nt.type.View;

public interface ICoronaVaccineMgmtService {
	      public <T extends View> List<T>  searchVaccinesByCompany(String company , Class<T> clazz);
	 }
