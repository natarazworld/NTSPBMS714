package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nt.listener.JobMonitoringListener;
import com.nt.processor.BookDetailsProcessor;
import com.nt.reader.BookDetailsReader;
import com.nt.writer.BookDetailsWriter;

//@Configuration
//@EnableBatchProcessing   // Gives spring batch features through  autoConfiguration
                                                    // like giving InMemoryJobRepository, JobBuilderFactory,StepBuildFactory 
                                                    // and etc..
public class BatchConfig {
	@Autowired
	private  JobBuilderFactory  jobFactory;
	@Autowired
	private  StepBuilderFactory  stepFactory;
	@Autowired
	private  BookDetailsWriter bdWriter;
	@Autowired
	private  BookDetailsReader bdReader;
	@Autowired
	private  BookDetailsProcessor bdProcessor;
	@Autowired
	private  JobMonitoringListener  jobListener;
	
	//create step object using StepBuilderFactory
	@Bean(name="step1")
	  public Step  createStep1() {
		System.out.println("BatchConfig.createStep1()");
		      return  stepFactory.get("step1")
		    		                                .<String,String>chunk(1)
		    		                                .reader(bdReader)
		    		                                .writer(bdWriter)
		    		                                .processor(bdProcessor)
		    		                                .build();
	  }
	
	//create Job  using JobBuilderFactory
	@Bean(name="job1")
	public   Job createJob() {
		System.out.println("BatchConfig.createJob()");
		return   jobFactory.get("job1")
				                            .incrementer(new RunIdIncrementer())
				                            .listener(jobListener)
				                            .start(createStep1())
				                            .build();
		
	}
	
}
