package com.mppl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.authorizeRequests()
			.antMatchers("/").hasRole("USER")
			.antMatchers("/admin/").hasRole("ADMIN")
			.and()
			.formLogin().loginPage("/login.html")
			.failureUrl("/login-error.html")
			.and()
			.logout()
			.logoutSuccessUrl("/home/index.html");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("jaya").password("jaya").roles("USER")
			.and()
			.withUser("sion").password("sion").roles("USER","ADMIN");
	}
}
