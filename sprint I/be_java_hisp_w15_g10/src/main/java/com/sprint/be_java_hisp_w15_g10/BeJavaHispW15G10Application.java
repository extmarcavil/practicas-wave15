package com.sprint.be_java_hisp_w15_g10;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeJavaHispW15G10Application {

	public static void main(String[] args) {
		SpringApplication.run(BeJavaHispW15G10Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
