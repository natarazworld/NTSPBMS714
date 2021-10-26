package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity   // makes the Normal @Configuration class Spring Security Configuration class
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private  DataSource ds;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?")   //for autheentication
		.authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM USER_ROLES WHERE UNAME=?");  //for authorization
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//authorize requests
	      http.authorizeRequests().antMatchers("/").permitAll()  //Not authetication an no authorization
	      .antMatchers("/offers").authenticated()  //only authentication
	      .antMatchers("/balance").hasAnyAuthority("CUSTOMER","MANAGER")  // authentication + authorization for  "CUSTOMER","MANAGER" role uses
					  .antMatchers("/loanApprove").hasAuthority("MANAGER")  //// authentication + authorization for 
         .anyRequest().authenticated()  //remaing all requests url mus be authtenticated
	      
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
