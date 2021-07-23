package com.nt.service;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
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

	/*CREATE OR REPLACE PROCEDURE P_AUTHENTICATION 
	(
	  UNAME IN VARCHAR2 
	, PWD IN VARCHAR2 
	, RESULT OUT VARCHAR2 
	) AS 
	 CNT NUMBER(5);
	BEGIN
	  
	  SELECT COUNT(*) INTO CNT FROM USERSLIST WHERE USERNAME=UNAME AND PASSWORD=PWD;
	   IF(CNT<>0)THEN
	      RESULT:='VALID CREDENTIALS';
	    ELSE
	      RESULT:='INVALID CREDENTIALS';
	   END IF;
	  
	END P_AUTHENTICATION;
	*/	
	

	@Override
	public String authenticate(String user, String pwd) {
		// create StoredProcedureQuery Object 
		StoredProcedureQuery query=manager.createStoredProcedureQuery(" P_AUTHENTICATION");
		//register Parmaeters
		query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class,ParameterMode.OUT);
		//set parameter values
		query.setParameter(1, user);
		query.setParameter(2, pwd);
		//call  the PRocedire
		query.execute();
		//gather results out parameter
		String result=(String) query.getOutputParameterValue(3);
		return result ;
	}
	
	/*	CREATE OR REPLACE FUNCTION FX_GET_EMP_DETAILS 
		(
		  ENO IN NUMBER 
		, NAME OUT VARCHAR2 
		, DESG OUT VARCHAR2 
		, SALARY OUT NUMBER 
		) RETURN NUMBER
		AS 
		  DNO NUMBER(3);
		BEGIN
	
		 SELECT ENAME,JOB,SAL,DEPTNO INTO NAME,DESG,SALARY,DNO FROM EMP WHERE EMPNO=ENO;
		 
		 RETURN DNO;
		  
		END FX_GET_EMP_DETAILS;
	*/	
	@Override
	public Object[] getEmpDetailsByEno(int eno) {
	      //unwrap  Session
		   Session ses=manager.unwrap(Session.class);
		   //write  plain jdbc to call PL/SQL function
		    Object obj[]=ses.doReturningWork(con->{
		    	//create Callable statement obj
		    	CallableStatement cs=con.prepareCall("{?=call FX_GET_EMP_DETAILS(?,?,?,?)}");
		    	//register return,out parmaters
		    	cs.registerOutParameter(1, Types.INTEGER); //return param (?1)
		    	cs.registerOutParameter(3, Types.VARCHAR); //return param (?3)
		    	cs.registerOutParameter(4, Types.VARCHAR); //return param (?4)
		    	cs.registerOutParameter(5, Types.FLOAT); //return param (?5)
		    	//set value IN param
		    	cs.setInt(2, eno);
		    	//call PL/SQL function
		    	cs.execute();
		    	//gather resutls from return, out params
		    	Object objs[]=new Object[4];
		    	objs[0]=cs.getInt(1);
		    	objs[1]=cs.getString(3);
		    	objs[2]=cs.getString(4);
		    	objs[3]=cs.getFloat(5);
		    	return objs;
		    });
		return obj;
	}

}
