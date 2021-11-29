package com.nt.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobMonitoringListener implements JobExecutionListener {
  private long start,end;
	@Override
	public void beforeJob(JobExecution jobExecution) {
		start=System.currentTimeMillis();
		System.out.println("Job is about to Start @"+new Date());

	}

	@Override
	public void afterJob(JobExecution jobExecution) {
	   end=System.currentTimeMillis();
	   System.out.println("Job completed at::"+new Date());
	   System.out.println("Job Exection time::"+(end-start)+" ms");
	   System.out.println("Job completion status ::"+jobExecution.getStatus());

	}

}
