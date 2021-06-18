package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bill")
public class BillGenerator {
	@Value("#{info.dosaPrice +info.idlyPrice+info.pohaPrice}")
    private float  total;
    @Value("Paradise")
    private  String hotelName;
    @Autowired
    private ItemsInfo  items;
    
	@Override
	public String toString() {
		return "BillGenerator [total=" + total + ", hotelName=" + hotelName + ", items=" + items + "]";
	}
    
	
    
}
