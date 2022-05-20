package com.ejercicio.ElasticSearchEmployees.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansSpring {

    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

    @Bean
    public ObjectWriter getObjectWriter() {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer()
                .withDefaultPrettyPrinter();
    }
}
