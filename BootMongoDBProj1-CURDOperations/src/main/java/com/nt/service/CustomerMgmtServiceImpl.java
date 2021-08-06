package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Customer;
import com.nt.repository.ICustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	 private ICustomerRepo custRepo;

	@Override
	public String registerCustomer(Customer doc) {
		return "Customer is saved with "+custRepo.save(doc).getId();
		//return "Customer is saved with "+custRepo.insert(doc).getId();
	}

	@Override
	public List<Customer> findAllCustomers() {
		return custRepo.findAll();
	}
	
	@Override
	public String removeCustomer(String id) {
		  //Get Document obj  by id
		Optional<Customer>  opt=custRepo.findById(id);
		if(opt.isPresent()) {
			custRepo.delete(opt.get());
			return "Document  is deleted";
		}
		return "Document  not found";
	}
	
	@Override
	public List<Customer> fetchCustomersByBillAmountRange(double start, double end) {
		
		return custRepo.findByBillAmtBetween(start, end);
	}
	
	@Override
	public List<Customer> fetchCustomersByUsingCaddAndHavingMobileNo(String... address) {
		return custRepo.findByCaddInAndMobileNoIsNotNull(address);
	}

}
