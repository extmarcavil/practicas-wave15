package com.elastic.crud.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansSpringConfig {

    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

}
