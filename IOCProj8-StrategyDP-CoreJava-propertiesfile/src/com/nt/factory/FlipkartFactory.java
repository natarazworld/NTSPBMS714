package com.nt.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import com.nt.comp.BlueDart;
import com.nt.comp.Courier;
import com.nt.comp.DTDC;
import com.nt.comp.Flipkart;

public class FlipkartFactory {
	private static Properties props;
	static {
		try {
		//Locate Prorperties file
		InputStream is=new FileInputStream("src/com/nt/commons/inputs.properties");
		// Load properties file content into  java.util.Properties class obj
		 props=new Properties();
		 props.load(is);
		}
		catch(IOException ioe) {
			 ioe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	//static factory method  having factory patter logic
	  public static  Flipkart  getInstance() {
		  
		  try {
		  //get Dependent class name (courier name) from properties file (java.util.Properties clas obj)
		   String courierClassName=props.getProperty("courier.type");
		   //Load and create dependent class object
		     Class c=Class.forName(courierClassName);
		      //Courier courier=(Courier)c.newInstance();  //deprecated from java9
		     Constructor cons[]=c.getDeclaredConstructors();
		    Courier courier=(Courier) cons[0].newInstance();
		      //create Target class obj
		       Flipkart  fpkt=new Flipkart();
		       //assign Dependent class obj to target class obj
		        fpkt.setCourier(courier);
		        return fpkt;
     	  }//try
		  catch(ClassNotFoundException cnf) {
			  cnf.printStackTrace();
			  return null;
		  }
		  catch(Exception e) {
			  e.printStackTrace();
			  return null;
		  }
	  }//method
}//class
