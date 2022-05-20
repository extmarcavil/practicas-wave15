package com.example.empleados.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansSpring {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
