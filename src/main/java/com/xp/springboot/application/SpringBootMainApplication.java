package com.xp.springboot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Neeraj Sidhaye
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.xp.springboot.*")
@EnableJpaRepositories("com.xp.springboot.*")
@EntityScan("com.xp.springboot.*")
public class SpringBootMainApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainApplication.class, args);
	}
	

    public static void start()  {
    	 SpringApplication.run(SpringBootMainApplication.class);
    }
	
}
