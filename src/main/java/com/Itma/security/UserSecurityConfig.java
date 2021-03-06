package com.Itma.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity

public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		return new UserDetailsServiceImpl();
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(userDetailsService());
		
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.authenticationProvider(authenticationProvider());
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
//		http.authorizeRequests()
//		    .antMatchers("/user/register").permitAll()
//		    .antMatchers("/user/submit").permitAll()
//		    .antMatchers("/user/").permitAll()
//		    .antMatchers("/user/**").access("hasRole('USER')")
//		    .antMatchers("/").permitAll()
//		    .and()
//		    .formLogin()
//		     .usernameParameter("email")
//		     .defaultSuccessUrl("/user/loginSuccess")
//		     .permitAll()
//		     .and()
//		     .logout().invalidateHttpSession(true).clearAuthentication(true)
//		     .logoutSuccessUrl("/").permitAll()
//		     .and().csrf().disable();
		    
		http.csrf().disable();
		
	}
	
	
	
	

}
