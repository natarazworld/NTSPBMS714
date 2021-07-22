package com.nt.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;

@Service("vaccineService")
public class VaccineMgmtServiceImpl implements IVaccineMgmtService {
	@Autowired
	private  EntityManager manager;
	
	
	/*CREATE OR REPLACE PROCEDURE P_GET_VACCINES_BY_PRICERANGE 
	(
	  STARTPRICE IN FLOAT 
	, ENDPRICE IN FLOAT 
	, DETAILS OUT SYS_REFCURSOR 
	) AS 
	
	BEGIN
	  open DETAILS FOR
	     SELECT REG_NO,NAME,COMPANY,COUNTRY,PRICE,REQUIRED_DOSE_COUNT 
	                      FROM CORONA_VACCINE WHERE PRICE>=STARTPRICE  AND PRICE<=ENDPRICE;
	  
	END P_GET_VACCINES_BY_PRICERANGE;
	*/	

	@Override
	public List<CoronaVaccine> searchVaccinesByPriceRange(double min, double max) {
		  //create StoredProcedure obj represeting our PL/SQL procedure
	       StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_VACCINES_BY_PRICERANGE",CoronaVaccine.class);
	       //register  Parameters of PL/SQL procedure
	       query.registerStoredProcedureParameter(1,Double.class,ParameterMode.IN);
	       query.registerStoredProcedureParameter(2,Double.class,ParameterMode.IN);
	       query.registerStoredProcedureParameter(3,CoronaVaccine.class,ParameterMode.REF_CURSOR);
	       //set values to parameters
	       query.setParameter(1, min);
	       query.setParameter(2, max);
	       //call PL/SQL procedure
	       List<CoronaVaccine> list=query.getResultList();
	       return list;
	}

}
