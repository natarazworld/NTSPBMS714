package com.nt.processor;

import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;

import com.nt.model.IExamResult;
import com.nt.model.OExamResult;

public class ExamResultItemProcessor implements ItemProcessor<IExamResult,OExamResult> {

	@Override
	public OExamResult process(IExamResult item) throws Exception {
		 if(item.getPercentage()<=80) {
			 OExamResult result=new OExamResult();
			 result.setId(item.getId());
			 result.setDob(LocalDate.parse(item.getDob()));
			 result.setPercentage(item.getPercentage());
			 result.setSemester(item.getSemester());
			 return result;
		 }
		   
		 else
			 return null;
	}
	

}
