package com.nt.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {
	
	@Scheduled(cron = "1 35 8 12  * *")
     public  void  generateSalesReport() {
	  System.out.println("Sales Report Data::"+new Date());
	}
	

}
