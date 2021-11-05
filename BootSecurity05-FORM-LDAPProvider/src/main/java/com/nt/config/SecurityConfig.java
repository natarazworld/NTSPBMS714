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
		auth.ldapAuthentication().contextSource().url("ldap://localhost:10389/o=nit")
		.managerDn("uid=admin,ou=system").managerPassword("secret")    //for connecting LDAP server
		.and()
		.userSearchBase("ou=users").userSearchFilter("(cn={0})")  //for authentication
		.groupSearchBase("ou=roles").groupSearchFilter("(uniqueMember={0})")
		.groupRoleAttribute("cn").rolePrefix("ROLE_");  // For Authorization
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {   //note ::  In LDAP server env.. use hasRole(-) not hasAuthority(-) method
		//authorize requests
	      http.authorizeRequests().antMatchers("/").permitAll()  //Not authetication an no authorization
	      .antMatchers("/offers").authenticated()  //only authentication
	      .antMatchers("/balance").hasAnyRole("CUSTOMER","MANAGER")  // authentication + authorization for  "CUSTOMER","MANAGER" role uses
					  .antMatchers("/loanApprove").hasRole("MANAGER")  //// authentication + authorization for 
					      .anyRequest().authenticated()  //remaing all requests url mus be authtenticated
	      
	      //specify  authentication mode
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
