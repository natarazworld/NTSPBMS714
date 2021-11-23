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
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.Employee;
import com.nt.processor.EmployeeInfoItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private DataSource ds;
	@Autowired
	private JobBuilderFactory jobFactory;
	@Autowired
	private StepBuilderFactory stepFactory;
	
	
	// listener
	@Bean
	public  JobExecutionListener  createListener() {
		 return new JobMonitoringListener();
	}
	
	//processor
	@Bean
	public    ItemProcessor<Employee, Employee>  createProcessor(){
		return new  EmployeeInfoItemProcessor();
	}
	
	
	/*//reader
	@Bean(name="reader")
	public  ItemReader<Employee>  createReader(){
		    //create object for  FlatFileItemReader
		       FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>();
		       // set source csv file location
		       reader.setResource(new ClassPathResource("Employee_Info.csv"));
		       //reader.setResource(new FileSystemResource("e:\\abc\\Employee_Info.csv");
		       //reader.setResource(new UrlResource("http://nit.com/csv/Employee_Info.csv")
		       //  set LineMapper
		       reader.setLineMapper(new DefaultLineMapper<Employee>(){{
		    	           //set LineTokenizer
		    	        setLineTokenizer(new DelimitedLineTokenizer() {{
		    	        	  setDelimiter(",");
		    	        	  setNames("empno","ename","salary","eadd");
		    	        }});
		    	        //set FiledsetMapper to write each Line content to Model obj
		    	        setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {{
		    	        	  setTargetType(Employee.class);
		    	        }});
		       }});
		    		   
		return  reader;
	}*/
	
	/* @Bean(name="reader")	
	  public  ItemReader<Employee>  createReader(){
		    //create object for  FlatFileItemReader
		       FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>();
		       // set source csv file location
		       reader.setResource(new ClassPathResource("Employee_Info.csv"));
		       //reader.setResource(new FileSystemResource("e:\\abc\\Employee_Info.csv");
		       //reader.setResource(new UrlResource("http://nit.com/csv/Employee_Info.csv")
		       //Line Mapper
		       DefaultLineMapper<Employee>  lineMapper=new DefaultLineMapper<Employee>();
		       //Line Tokenizer
		       DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
		       lineTokenizer.setDelimiter(",");
		       lineTokenizer.setNames("empno","ename","salary","eadd");
		       //FiledSet mapper
		       BeanWrapperFieldSetMapper<Employee> mapper=new BeanWrapperFieldSetMapper<Employee>();
		       mapper.setTargetType(Employee.class);
		       //add LineTokenizer,FieldSetMapper to  LineMapper
		       lineMapper.setLineTokenizer(lineTokenizer);
		       lineMapper.setFieldSetMapper(mapper);
		       //add LineMapper to  Reader
		       reader.setLineMapper(lineMapper);
		return  reader;
	}*/
	
	@Bean(name="reader")
	public  ItemReader<Employee>  createReader(){
	   return  new  FlatFileItemReaderBuilder<Employee>()
			                    .name("file-reader")
			                    .resource(new ClassPathResource("Employee_Info.csv"))
			                    .delimited().delimiter(",")   // makes us to use DefaultLineMapper, DefaultLineTokenizer
			                    .names("empno","ename","salary","eadd")
			                    .targetType(Employee.class)
			                    .build();
	}
	
	
	/*	//writer
		@Bean(name="writer")
		public  ItemWriter<Employee>  createWriter(){
			 JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter();
			 //set DataSource 
			 writer.setDataSource(ds);
			 //set SQL query with named params
			 writer.setSql("INSERT INTO  BATCH_EMPLOYEE VALUES(:empno,:ename,:salary,:eadd,:grossSalary,:netSalary)");
			 //set Model class obj as SqParameterSourceProvider (here  named param names and  model class obj property names must match) 
			 writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
			 return writer;
		}*/
	
	@Bean(name="writer")
	public  ItemWriter<Employee>  createWriter(){
		return new  JdbcBatchItemWriterBuilder<Employee>()
				               .dataSource(ds)
				               .sql("INSERT INTO  BATCH_EMPLOYEE VALUES(:empno,:ename,:salary,:eadd,:grossSalary,:netSalary)")
				               .beanMapped()    // makes to use BeanProperyItemSqlParmaeterSourceProvider internally
				               .build();
		
	}
	
	@Bean(name="step1")
	public   Step  createStep1() {
		  return stepFactory.get("step1")
				           .<Employee,Employee>chunk(3)
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
