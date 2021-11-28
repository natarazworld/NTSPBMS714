package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.ExamResult;
import com.nt.processor.ExamResultItemProcessor;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
	@Autowired
	private  DataSource ds;
	@Autowired
	private  JobBuilderFactory jobFactory;
	@Autowired
	private StepBuilderFactory stepFactory;
	
	//listener
	@Bean
	public   JobExecutionListener createListener() {
		return new JobMonitoringListener();
	}
	
	//processor
	@Bean
	public    ItemProcessor<ExamResult,ExamResult>  createProcessor(){
		return  new  ExamResultItemProcessor();
	}
	
	
	//reader
	/*@Bean
	public   JdbcCursorItemReader<ExamResult>  createReader(){
		//create object
		    JdbcCursorItemReader<ExamResult> reader=new JdbcCursorItemReader<>();
		 // specify DataSoruce
		    reader.setDataSource(ds);
		// specify SQL Query
		    reader.setSql("SELECT ID,DOB,PERCENTAGE,SEMESTER FROM EXAM_RESULT");
		 //specify RowMapper
		    //reader.setRowMapper(new ExamResultRowMapper());
		    reader.setRowMapper((rs,rowNumber)->new ExamResult(rs.getInt(1),
		    		                                                                                    rs.getDate(2), 
		    		                                                                                    rs.getDouble(3), 
		    		                                                                                    rs.getInt(4)));
		
		return reader;
	}*/
	
	@Bean
	public   JdbcCursorItemReader<ExamResult>  createReader(){
		//create and return object
		return  new JdbcCursorItemReaderBuilder<ExamResult>()
				               .name("jdbc-reader")
				              .dataSource(ds)
				              .sql("SELECT ID,DOB,PERCENTAGE,SEMESTER FROM EXAM_RESULT")
				              .beanRowMapper(ExamResult.class)  // Internally use BeanPropertyRowMapper
				                                                                                         // to covert the record of RS to given Model class obj
				                                                                                        // but  db table col names  and  model class properties
				              .build();
				              
		 
	}
	
	//writer
	 @Bean
	public    FlatFileItemWriter<ExamResult> createWriter(){
		 FlatFileItemWriter<ExamResult> writer=new FlatFileItemWriter<>();
		 //set logical name
		// writer.setName("writer-csv");
		 //specify the destination csv file location
		 //writer.setResource(new ClassPathResource("classpath:topbrains.csv"));
		 writer.setResource(new FileSystemResource("e:\\csvs\\topbrains.csv"));
		 // specify  LineAggregator by  supplying  delimeter and FieldExtractor
		 writer.setLineAggregator(new DelimitedLineAggregator<>() {{
			 //delimeter
			   setDelimiter(",");
			   //field extractor
			   setFieldExtractor(new BeanWrapperFieldExtractor<>() {{
				      //specify  names to extracted field values.
				   setNames(new String[] {"id","dob","percentage","semester"});
			   }});
		 }});
		return writer;
	}
	
	/*@Bean
	public    FlatFileItemWriter<ExamResult> createWriter(){
		   return  new  FlatFileItemWriterBuilder<ExamResult>()
				                     .name("line123")
				                     .resource(new ClassPathResource("TopBrains.csv"))
				                     .lineSeparator("\r\n")
				                     .delimited().delimiter(",")
				                     .names("id","dob","percentage","semester")
				                     .build();
	}*/
	
	//step
	 
	 @Bean(name="step1")
	 public  Step  createStep1() {
		 return stepFactory.get("step1")
				       .<ExamResult,ExamResult>chunk(3)
				       .reader(createReader())
				       .writer(createWriter())
				       .processor(createProcessor())
				       .build();
	 }
	 
	 @Bean(name="job1")
	 public   Job createJob1() {
		   return  jobFactory.get("job1")
				          .incrementer(new RunIdIncrementer())
				          .listener(createListener())
				          .start(createStep1())
				          .build();
	 }

}
