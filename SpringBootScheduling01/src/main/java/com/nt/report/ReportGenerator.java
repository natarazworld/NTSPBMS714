package com.nt.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {
	
	//@Scheduled(initialDelay = 2000,fixedDelay = 3000)                                      //1000ms = 1sec
	//@Scheduled(fixedDelay = 3000)
	//@Scheduled(fixedDelayString =  "3000")
	@Scheduled(initialDelay =2000 ,fixedRate= 5000)
     public  void  generateSalesReport() {
		System.out.println("thread(task1) name ::"+Thread.currentThread().getName());
		System.out.println("thread(task1) hashCode::"+Thread.currentThread().hashCode());
		System.out.println("Report Data on"+new Date());
	}
	
	@Scheduled(fixedDelay =3000,initialDelay = 2000)
    public  void  generateSalesReport1() {
		System.out.println("thred (task2) name ::"+Thread.currentThread().getName());
		System.out.println("thread(task2) hashCode::"+Thread.currentThread().hashCode());
		System.out.println("Report Data1 on"+new Date());
	}

}
