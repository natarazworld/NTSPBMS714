package com.nt.service;

import java.util.List;

import com.nt.entity.Customer;

public interface ICustomerMgmtService {
    public  String  registerCustomer(Customer cust);
    public  List<Customer>  getAllCusotmers();
}
