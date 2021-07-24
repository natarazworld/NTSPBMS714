package com.nt.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Emp;

@Service("vaccineService")
public class EmpMgmtServiceImpl implements IEmpMgmtService {
	@Autowired
	private  EntityManager manager;
	
	
	/*CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_EMPDETAILS_BY_DESGS`(IN desg1 varchar(10) , IN desg2 varchar(10))
			BEGIN
			     select empno,ename,job,sal from emp where job in (desg1,desg2) order by job;
			END
	*/

	@Override
	public List<Emp> searchEmpsByDesgs(String desg1, String desg2) {
		//create StoredProcedureQuery object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("GET_EMPDETAILS_BY_DESGS",Emp.class);
		//register parmaeters
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		//set parameter values
		query.setParameter(1, desg1);
		query.setParameter(2, desg2);
		//call PL/SQL procedure and get Result
		List<Emp>  listEmps=query.getResultList();
		return listEmps;
	}

}
