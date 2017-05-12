package com.mppl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.authorizeRequests()
			.antMatchers("/").hasRole("USER")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.and()
			.formLogin().loginPage("/login")
			.failureUrl("/login-error")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login")
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("jaya").password("jaya").roles("USER")
			.and()
			.withUser("sion").password("sion").roles("USER","ADMIN");
	}
}
