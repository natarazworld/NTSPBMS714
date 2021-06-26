package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;


@SpringBootApplication
public class BootProj04RealtimeDiAutoConfigurationApplication {
	@Autowired
	private Environment env;
	
	@Bean(name="cds")
	@Profile({"uat","default"})
	public  ComboPooledDataSource  createC3PODs() throws Exception {
		System.out.println("BootProj04RealtimeDiAutoConfigurationApplication.createC3PODs()");
		ComboPooledDataSource  cds=new ComboPooledDataSource();
		cds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		cds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		cds.setUser(env.getRequiredProperty("spring.datasource.username"));
		cds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return cds;
	}
	
	@Bean(name="tcp")
	@Profile("default")
	public DataSource    createTomcatCPDs() throws Exception {
		System.out.println("BootProj04RealtimeDiAutoConfigurationApplication.createTomcatCPDs()");
		DataSource tcpds=new DataSource();
		tcpds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		tcpds.setUrl("jdbc:mysql:///NTSPBMS714DB");
		tcpds.setUsername("root");
		tcpds.setPassword("root");
		return tcpds;
	}


	public static void main(String[] args) {
		//read inputs from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Desgs count::");
		int count=sc.nextInt();
		String desgs[]=null;
		if(count>=1)
		    desgs=new String[count];
		else {
			System.out.println("invalid desg count ");
			return;
		}
		for(int i=0;i<count;++i) {
			System.out.println("enter desg"+(i+1));
			String desg=sc.next();
			desgs[i]=desg;
		}
	    
		SpringApplication application=new SpringApplication( BootProj04RealtimeDiAutoConfigurationApplication.class );
		//application.setAdditionalProfiles("uat");
		ApplicationContext ctx=application.run(args);
		 
		//get Controller class obj
		MainController controller=ctx.getBean("controller",MainController.class);
		//invoke b.method
		try {
			List<EmployeeVO> listVO=controller.showEmpsByDesgs(desgs);
			System.out.println("Emp details having "+Arrays.toString(desgs));
			listVO.forEach(vo->{
				System.out.println(vo);
			});
		}//try
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Some Internal problem::"+e.getMessage());
		}
		//close IOC container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
