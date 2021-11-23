package com.nt.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component("jmListener")
public class JobMonitoringListener implements JobExecutionListener {
   private long startTime, endTime;
   
   public JobMonitoringListener() {
	System.out.println("JobMonitoringListener:: 0-param constructor");
  }
   
	@Override
	public void beforeJob(JobExecution jobExecution) {
           System.out.println("Job is about to beging at::"+new Date());
           startTime=System.currentTimeMillis();
           System.out.println("Job Status ::"+jobExecution.getStatus());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		   System.out.println("Job completed at::"+new Date());
		   endTime=System.currentTimeMillis();
		   System.out.println("Job Status ::"+jobExecution.getStatus());
		   System.out.println("Job Exection time ::"+(endTime-startTime));
		   System.out.println("Job Exit Status ::"+jobExecution.getExitStatus());

	}

}
