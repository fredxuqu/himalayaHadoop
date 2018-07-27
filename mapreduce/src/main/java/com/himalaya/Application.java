package com.himalaya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2017年7月25日 下午5:45:47
* Description
*/
@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ServletComponentScan
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		LOGGER.info("Spring Boot Has Been Started.");
	}
}