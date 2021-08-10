package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Customer;
import com.nt.repo.ICustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private  ICustomerRepo  custRepo;

	@Override
	public List<Object[]> fetchCustomersDataByCadd(String addrs) {
		return custRepo.getCustomersDataByCadd(addrs);
	}

	@Override
	public List<Customer> fetchCustomersByCadd(String addrs) {
		return custRepo.getCustomersByCadd(addrs);
	}
	
	@Override
	public List<Object[]> fetchCustomersDataByCaddAndCname(String addrs, String name) {
		return custRepo.getCustomersByCaddAndName(addrs, name);
	}
	
	@Override
	public List<Object[]> fetchCustomersDataByCaddOrCname(String addrs, String name) {
	
		return custRepo.getCustomersByCaddOrName(addrs, name);
	}
	
	@Override
	public List<Object[]> fetchCustomersDataByBillAmtRange(double start, double end) {
		return custRepo.getCustomersDataByBillAmtRange(start, end);
	}

}
