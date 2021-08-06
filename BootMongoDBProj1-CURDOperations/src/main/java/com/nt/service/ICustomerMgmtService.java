package com.nt.service;

import java.util.List;

import com.nt.document.Customer;

public interface ICustomerMgmtService {
     public   String   registerCustomer(Customer doc);
     public  List<Customer> findAllCustomers();
     public   String  removeCustomer(String id);
     public  List<Customer>  fetchCustomersByBillAmountRange(double start,double end);
     public  List<Customer>  fetchCustomersByUsingCaddAndHavingMobileNo(String ...address);
}
