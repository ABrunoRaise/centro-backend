package com.tecnositaf.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.tecnositaf.backend.mapper")
public class CentroBackendApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CentroBackendApplication.class, args);
	}

}
