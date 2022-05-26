package com.mercadolibre.bootcamp_demo_java_app.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import com.mercadolibre.routing.RoutingFilter;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan("com.mercadolibre.bootcamp_demo_java_app")
@Configuration
@EnableAutoConfiguration
public class SpringConfig implements WebMvcConfigurer {
	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(createAfterburnerModule());
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		objectMapper.setDateFormat(sdf);
		return objectMapper;
	}

	@Bean
	@Order(1)
	public RoutingFilter getRoutingFilter() {
		return new RoutingFilter();
	}

	private AfterburnerModule createAfterburnerModule() {
		AfterburnerModule afterburnerModule = new AfterburnerModule();

		// make Afterburner generate bytecode only for public getters/setter and fields
		// without this, Java 9+ complains of "Illegal reflective access"
		afterburnerModule.setUseValueClassLoader(false);
		return afterburnerModule;
	}
}
