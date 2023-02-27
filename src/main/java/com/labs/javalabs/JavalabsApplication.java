package com.labs.javalabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync
public class JavalabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavalabsApplication.class, args);
	}

}
