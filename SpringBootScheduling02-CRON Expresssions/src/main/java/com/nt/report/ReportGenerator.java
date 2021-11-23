package com.nt.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {
	
	//@Scheduled(cron = "1 35 8 12  * *")
	//@Scheduled(cron="0/20 * * * * *")
	//@Scheduled(cron="10 0/1 * * * *")
	//@Scheduled(cron="20 0/1 9 * * *")
	//@Scheduled(cron="0/5 0/2 10 * * *")
	//@Scheduled(cron="@hourly")
	//@Scheduled(cron="0  2  11  L *  *")
	//@Scheduled(cron="0  9  11 *  *  7#2")
	//@Scheduled(cron="0  50  10 10W  *  *")
	//@Scheduled(cron="0  11 7  LW  *  *")
	//@Scheduled(cron="0  15 7  1W  *  *")
	//@Scheduled(cron="0  4 0  LW  *  *")
	@Scheduled(cron="0  0 0 17W  *  *")
     public  void  generateSalesReport() {
	  System.out.println("Sales Report Data::"+new Date());
	}
	

}
