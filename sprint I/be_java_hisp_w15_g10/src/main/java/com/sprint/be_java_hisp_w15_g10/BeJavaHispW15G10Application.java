package com.sprint.be_java_hisp_w15_g10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BeJavaHispW15G10Application {

	@Bean
	public Docket productApoi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sprint.be_java_hisp_w15_g10")).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(BeJavaHispW15G10Application.class, args);
	}
}
