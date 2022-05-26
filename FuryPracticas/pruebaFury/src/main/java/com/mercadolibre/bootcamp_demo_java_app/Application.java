package com.mercadolibre.bootcamp_demo_java_app;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mercadolibre.bootcamp_demo_java_app.config.SpringConfig;
import com.mercadolibre.bootcamp_demo_java_app.util.ScopeUtils;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ScopeUtils.calculateScopeSuffix(); new SpringApplicationBuilder(SpringConfig.class).registerShutdownHook(true).run(args);
	}	
}
