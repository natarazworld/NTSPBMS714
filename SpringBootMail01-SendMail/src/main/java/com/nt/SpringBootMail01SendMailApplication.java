package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.IpurchaseOrder;

@SpringBootApplication
public class SpringBootMail01SendMailApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(SpringBootMail01SendMailApplication.class, args);
		// get Serivce class object ref
		IpurchaseOrder order=ctx.getBean("purchaseService",IpurchaseOrder.class);
		//invoke method
		try {
		String msg=order.purchase(new String[] {"shirt","trouser","watch"},
                                           new double[] {5000,6000,7000},
                                           new String[] {"nataraz@gmail.com","sreeni.moto@gmail.com","mranil900@gmail.com",
                                        		                     "prakash.er127@gmail.com","sabita11038@gmail.com"});
		System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
