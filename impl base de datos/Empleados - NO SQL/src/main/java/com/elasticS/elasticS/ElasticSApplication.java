package com.elasticS.elasticS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ElasticSApplication {

	public static void main(String[] args) {

		SpringApplication.run(ElasticSApplication.class, args);
	}

}
