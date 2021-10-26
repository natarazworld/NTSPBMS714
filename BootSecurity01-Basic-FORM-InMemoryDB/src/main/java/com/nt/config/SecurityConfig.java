package com.nt.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity   // makes the Normal @Configuration class Spring Security Configuration class
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	    // Build Authentication Manager by taking  given Authentication Info Provider (InMemoryDB)  
		/*	 auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").authorities("CUSTOMER");
			 auth.inMemoryAuthentication().withUser("ramesh").password("{noop}hyd").authorities("MANAGER");*/
		
		/*auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("ramesh").password("{noop}hyd").roles("MANAGER");*/
		
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$irWQwKOV6vm9Ksf7b11Ttu1RrjrJUrGQK4Pah8FGj8JvngJqjKKqe").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("ramesh").password("$2a$10$SgFbtmR9u3SXkvR7rQrdbuJYhtJuHNqplB2uoVS.shEtSGkb2ibmS").roles("MANAGER");
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//authorize requests
	      http.authorizeRequests().antMatchers("/").permitAll()  //Not authetication an no authorization
	      .antMatchers("/offers").authenticated()  //only authentication
	      .antMatchers("/balance").hasAnyRole("CUSTOMER","MANAGER")  // authentication + authorization for  "CUSTOMER","MANAGER" role uses
					  .antMatchers("/loanApprove").hasRole("MANAGER")  //// authentication + authorization for 
					/*	      .antMatchers("/balance").hasAnyAuthority("CUSTOMER","MANAGER")  // authentication + authorization for  "CUSTOMER","MANAGER" role uses
					  .antMatchers("/loanApprove").hasAuthority("MANAGER")  //// authentication + authorization for  "MANAGER" role user
					*/	      .anyRequest().authenticated()  //remaing all requests url mus be authtenticated
	      
	      //specify  authentication mode
	      //.and().httpBasic()
			.and().formLogin()
		 // add remember filter
			.and().rememberMe()
	      
	      //add Logout Filter
	      //.and().logout()
			 .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
	     
	      
	      //exception/error handling
	     .and().exceptionHandling().accessDeniedPage("/denied")
	      
          // add  SessionMaxConcurrency count 
			.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);

	      
	      
	}

}
