package com.pramati.flashsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.pramati.flashsale"})
@EntityScan("com.pramati.flashsale.model")
@EnableJpaRepositories("com.pramati.flashsale.repository")
public class Application extends SpringBootServletInitializer{
	
	public static void main(String args[]) {
		
		 SpringApplication.run(Application.class, args);
		
	}

}
