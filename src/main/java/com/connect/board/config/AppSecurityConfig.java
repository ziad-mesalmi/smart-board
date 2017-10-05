package com.connect.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import com.connect.board.security.JWTAuthenticationFilter;
import com.connect.board.security.JWTLoginFilter;
import com.connect.board.service.impl.MongoDBAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private MongoDBAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/", "/about", "/name").permitAll()
		.antMatchers(HttpMethod.POST, "/login")
		.permitAll().antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		// We filter the api/login requests
		.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
				UsernamePasswordAuthenticationFilter.class)
		// And filter other requests to check the presence of JWT in header
		.addFilterBefore(new JWTAuthenticationFilter(),
				UsernamePasswordAuthenticationFilter.class);
//		http.httpBasic().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Create a default account
//		auth.inMemoryAuthentication()
//		.withUser("admin")
//		.password("password")
//		.roles("ADMIN");
//		
//		auth.inMemoryAuthentication()
//		.withUser("user")
//		.password("password")
//		.roles("USER");
		auth.authenticationProvider(authenticationProvider);
	}
}
