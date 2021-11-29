package com.nt.runner;

import java.util.Random;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchProcessingTest  {
	@Autowired
	private  JobLauncher launcher;
	@Autowired
	private  Job job;

	@Scheduled(cron = "${cron.expr}")
	public void runJob() throws Exception  {
		//prepare  Job Parameters
		JobParameters params=new JobParametersBuilder()
				                                        .addLong("time",System.currentTimeMillis()).toJobParameters();
		//run the job
	JobExecution exeution=launcher.run(job, params);
		/*System.out.println("Job execution status ::"+exeution.getStatus());
		System.out.println("Exit Status ::"+exeution.getExitStatus());
		System.out.println(" Job Id"+exeution.getJobId());*/
		

	}

}
