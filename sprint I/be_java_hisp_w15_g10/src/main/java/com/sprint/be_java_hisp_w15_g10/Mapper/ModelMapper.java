package com.sprint.be_java_hisp_w15_g10.Mapper;

import org.springframework.context.annotation.Bean;

public class ModelMapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
