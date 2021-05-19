package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.bo.CustomerBO;
import com.nt.dao.ICustomerDAO;
import com.nt.dto.CustomerDTO;

@Service("custMgmtService")
public final class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	//@Qualifier("custOraDAO")
	@Qualifier("custMySQLDAO")
	 private  ICustomerDAO  dao;  //HAS-A property
	 
	 

	@Override
	public String calculateSimpleIntrest(CustomerDTO dto) throws Exception {
		//calculate simple intrest amount  (b.logic)
		float intrAmt=(dto.getPamt()*dto.getRate()*dto.getTime())/100.0f;
		//create BO class obj having persistable data
		CustomerBO bo=new CustomerBO();
		bo.setCustName(dto.getCustName());
		bo.setCustAddrs(dto.getCustAddrs());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setIntrestAmount(intrAmt);
		//use DAO
		int count=dao.insert(bo);
		  // terinary operator   <condition>?<sucess>:<failure>
		return  count==1?"Customer registered sucessfully---> SimpleIntrest amount::"+intrAmt:"Customer registration failed";   
	}

}
