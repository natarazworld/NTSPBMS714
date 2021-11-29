package com.nt.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.IExamResult;
import com.nt.model.OExamResult;
import com.nt.processor.ExamResultItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobFactory;
	@Autowired
	private StepBuilderFactory stepFactory;
	@Autowired
	private EntityManagerFactory  entityFactory;
	
	//listener
	@Bean
	public  JobExecutionListener createListener() {
		return new JobMonitoringListener();
	}
	//processor
	@Bean
	public  ExamResultItemProcessor createProcessor() {
		return  new  ExamResultItemProcessor();
	}
	
	/*@Bean
	public	FlatFileItemReader<IExamResult> createReader(){
		FlatFileItemReader<IExamResult> reader=new FlatFileItemReader<>();
		reader.setResource(new FileSystemResource("e:/csvs/TopBrains.csv"));
		reader.setLineMapper(new DefaultLineMapper<IExamResult>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(",");
				setNames("id","dob","percentage","semester");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<IExamResult>() {{
				 setTargetType(IExamResult.class);
			}});
			
		}});
		
		return reader;
	}*/
	
	//reader
	@Bean
	public  FlatFileItemReader<IExamResult> createReader(){
	     return  new FlatFileItemReaderBuilder<IExamResult>()
	    		        .name("csv-reader")
	    		        .resource(new FileSystemResource("e:/csvs/TopBrains.csv"))
	    		        .delimited()
	    		        .delimiter(",")
	    		        .names("id","dob","percentage","semester")
	    		        .targetType(IExamResult.class)
	    		        .build();
	}

	/*//writer
	@Bean
	public   JpaItemWriter<OExamResult>  createWriter(){
		JpaItemWriter<OExamResult> writer=new JpaItemWriter<>();
		//set EntityManager factory
		writer.setEntityManagerFactory(entityFactory);
		
		return writer;
	}
	*/
	@Bean
	public   JpaItemWriter<OExamResult>  createWriter(){
		return  new JpaItemWriterBuilder<OExamResult>()
				       .entityManagerFactory(entityFactory)
				       .build();
	}
		
	//step
		
		@Bean(name="step1")
		public   Step createStep1() {
			return   stepFactory.get("step1")
					        .<IExamResult,OExamResult>chunk(3)
					        .reader(createReader())
					        .writer(createWriter())
					        .processor(createProcessor())
					        .build();
		}
		
		@Bean(name="job1")
		public Job createJob1() {
			return jobFactory.get("job1")
					     .incrementer(new RunIdIncrementer())
					     .listener(createListener())
					     .start(createStep1())
					     .build();
		}
		
	
	
	

}
