package com.nt.comp;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component("fpkt")

/*@PropertySources(value= {@PropertySource("com/nt/commons/info.properties"),
                                                         @PropertySource("com/nt/commons/info1.properties")
                                                  }
                                       )*/

/*@PropertySource("com/nt/commons/info.properties")
@PropertySource("com/nt/commons/info1.properties")
*/

@PropertySource(value={"com/nt/commons/info.properties","com/nt/commons/info1.properties"})

//@Scope("prototype")
//@Component
public final class Flipkart {
	
	@Autowired
	@Qualifier("cr")
	private  Courier courier;
	@Autowired
	private  Date  myDate;
	
	/*@Value("https://www.flipkart.com")
	private  String url;
	@Value("30")
	private int age;  */
	
	@Value("${fpt.info.url}")
	private  String url;
	@Value("${fpt.info.age}")
	private int age;  
	
	@Value("${os.name}")   //injects system property value
	private String os;
	@Value("${Path}")   // injects PATH env.. variable value 
	private  String  pathValue;
	
	public Flipkart() {
		System.out.println("Flipkart:0-param consturctor");
	}
	
	//b,method
	public  String  shopping(String [] items, float[] prices) {
		System.out.println("Flipkart.shopping()::::"+url +"     "+age+"   "+myDate);
		System.out.println("Flipkart.shopping():::"+os+"......."+pathValue);
		float billAmt=0.0f;
		for(float p:prices)
			billAmt+=p;  // billAmt=billAmt+p
		//generate order id
		  int oid=new Random().nextInt(1000);
		  //use courier
		  String msg=courier.deliver(oid);
		  return  Arrays.toString(items)+" with prices"+Arrays.toString(prices)+" having billamt"+billAmt +" :::: "+ msg;
	}
	

}
