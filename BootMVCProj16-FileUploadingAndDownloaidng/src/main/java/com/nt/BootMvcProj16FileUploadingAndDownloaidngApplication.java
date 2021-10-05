package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class BootMvcProj16FileUploadingAndDownloaidngApplication {
	
	
	@Bean("multipartResolver")
	public  CommonsMultipartResolver createCMResolver() {
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSize(-1);  // -1 indicates no limit
		resolver.setMaxUploadSizePerFile(20*1024*1024);  //-1 inddicates no limit
		resolver.setPreserveFilename(true);
		return resolver;
	
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj16FileUploadingAndDownloaidngApplication.class, args);
	}

}
