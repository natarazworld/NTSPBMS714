package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@Configuration
public class AppConfig {
	
	@Bean
	public   Sampler  createSampler() {
		return  Sampler.ALWAYS_SAMPLE;
	}
	
	@Bean
	public   RestTemplate  createRestTemplate() {
		  return new  RestTemplate();
	}

}
