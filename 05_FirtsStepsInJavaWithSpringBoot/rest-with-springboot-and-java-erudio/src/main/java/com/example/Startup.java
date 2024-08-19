package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example")
//@EntityScan(basePackages = "com.example.services")
public class Startup {

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}

}
