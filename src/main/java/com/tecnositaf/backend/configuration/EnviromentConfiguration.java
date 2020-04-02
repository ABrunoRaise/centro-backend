package com.tecnositaf.backend.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource(value = "classpath:/${env}/database.properties", ignoreResourceNotFound = false),
	@PropertySource(value = "classpath:/${env}/service.properties", ignoreResourceNotFound = false)
})
public class EnviromentConfiguration {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${env}")
	private String env;
	
	@Value("${spring.data.mongodb.uri}")
	private String databaseUrl;
	
	@PostConstruct
	void init(){
		log.info("env => " + env);
		log.info("databaseUrl => " + databaseUrl);
	}
	
}
