package com.tecnositaf.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//TODO @MapperScan("com.tecnositaf.backend.mapper") oppure in application.properties
public class CentroBackendApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CentroBackendApplication.class, args);
	}

	//TODO @Bean for RestTemplate in class BeanConfiguration with @Configuration
}
