package com.connect.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

//@SpringBootApplication
//@Configuration
//@Import(RepositoryRestMvcConfiguration.class)
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication(scanBasePackages={"com.connect.board"})
public class SmartBoardApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SmartBoardApplication.class, args);
	}
}
