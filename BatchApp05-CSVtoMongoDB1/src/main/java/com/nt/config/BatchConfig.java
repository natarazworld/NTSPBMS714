package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.nt.document.OExamResult;
import com.nt.listener.JobMonitoringListener;
import com.nt.model.IExamResult;
import com.nt.processor.ExamResultItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobFactory;
	@Autowired
	private StepBuilderFactory stepFactory;
	@Autowired
	private  MongoTemplate template;
	
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
	
	@Bean
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
	}
	
	//writer
		@Bean
	public  MongoItemWriter<OExamResult> createWriter(){
		   MongoItemWriter<OExamResult> writer=new MongoItemWriter<>();
		   writer.setCollection("SuperBrains1");
		   writer.setTemplate(template);
		   return writer;
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
