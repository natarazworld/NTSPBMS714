package com.nt.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("LocalTimeEditor.setAsText()");
		//spilt the String date value whose pattern is yyyy-MM-ddThh:mm    
		String content[]=text.split("T");
		String dateContent[]=content[0].split("-");
		String timeContent[]=content[1].split(":");
		int year=Integer.parseInt(dateContent[0]);
		int month=Integer.parseInt(dateContent[1]);
		int day=Integer.parseInt(dateContent[2]);
		
		int hours=Integer.parseInt(timeContent[0]);
		int minutes=Integer.parseInt(timeContent[1]);
		//create LocalDate class obj
		LocalDateTime  ldt=LocalDateTime.of(year, month, day, hours, minutes);
		//set value to property
		setValue(ldt);
	}

}
