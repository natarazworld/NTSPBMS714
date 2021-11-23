package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("bdProcessor")
public class BookDetailsProcessor implements ItemProcessor<String,String> {
	
	public BookDetailsProcessor() {
		System.out.println("BookDetailsProcessor:: 0-param constructor");
	}
	

	@Override
	public String process(String item) throws Exception {
		System.out.println("BookDetailsProcessor.process()");
		    String bookWithTitle=null;
		   if(item.equalsIgnoreCase("CRJ"))
			      bookWithTitle=item+" by HS and PN";
		   else if(item.equalsIgnoreCase("TIJ"))
			   bookWithTitle=item+" by BE";
		   else if(item.equalsIgnoreCase("HFJ"))
			    bookWithTitle=item+" by KS";
		   else if(item.equalsIgnoreCase("EJ"))
			   bookWithTitle=item+" by JB";
		   else if(item.equalsIgnoreCase("BBJ"))
			   bookWithTitle=item+" by RNR";
		   
		   return bookWithTitle;
	}

}
