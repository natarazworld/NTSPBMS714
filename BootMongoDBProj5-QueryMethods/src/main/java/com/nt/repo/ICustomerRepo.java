package com.nt.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer,String > {
	
	 @Query(fields = "{id:1,cno:1,cname:1,cadd:1,billAmt:1}" ,value = "{cadd:?0}")
	public  List<Object[]> getCustomersDataByCadd(String addrs);
	
	//@Query(fields = "{}" ,value = "{cadd:?0}")  (or)
	@Query(value = "{cadd:?0}")
	public  List<Customer>   getCustomersByCadd(String addrs);
	
	@Query(fields = "{id:1,cno:1,cname:1,cadd:1}" ,value = "{cadd:?0,cname:?1}")
	public  List<Object[]>   getCustomersByCaddAndName(String addrs,String name);
	
	@Query(fields = "{id:1,cno:1,cname:1,cadd:1}" ,value = "{$or:[{cadd:?0},{cname:?1}]}")
	public  List<Object[]>   getCustomersByCaddOrName(String addrs,String name);
	
	
	//@Query(fields = "{id:1,cno:1,cname:1,cadd:1,billAmt:1}" ,value = "{billAmt:{$gte:?0} ,billAmt:{$lte:?1}}")  (or)
	@Query(fields = "{id:1,cno:1,cname:1,cadd:1,billAmt:1}" ,value = "{billAmt:{$gte:?0,$lte:?1}}")
	public  List<Object[]>   getCustomersDataByBillAmtRange(double start, double end);
	
	
	@Query(value="{ cadd: {$regex:?0}}")
	public List<Customer>  getCustomersByRegCadd(String addrs);
	
	@Query(value = "{billAmt:{$gte:?0,$lte:?1}}",count = true)
	public int   getCustomersCountByBillAmtRange(double start,double end);
	
	@Query(value="{}", sort="{ billAmt:-1}" )
	public   List<Customer> getCustomersByBillAmountSorted();
	
	@Query(value="{billAmt: null}", delete = true )
	public   int deleteCustomersWithNoBillAmt();
	
	@Query(value="{billAmt:{$gte:?0,$lte:?1} }", exists = true )
	public  boolean  areThereCustomersWithBillAmountRange(double start,double end);
	
	
		
	
	
	
	
	
}
