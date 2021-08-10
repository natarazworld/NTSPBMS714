package com.nt.service;

import java.util.List;

import com.nt.document.Customer;

public interface ICustomerMgmtService {
    public  List<Object[]> fetchCustomersDataByCadd(String addrs);
    public  List<Customer> fetchCustomersByCadd(String addrs);
    public  List<Object[]> fetchCustomersDataByCaddAndCname(String addrs,String name);
    public  List<Object[]> fetchCustomersDataByCaddOrCname(String addrs,String name);
    public  List<Object[]> fetchCustomersDataByBillAmtRange(double start, double end);
}
