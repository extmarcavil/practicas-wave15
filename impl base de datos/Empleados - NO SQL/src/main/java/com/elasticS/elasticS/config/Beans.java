package com.elasticS.elasticS.config;

import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class Beans {

    //esto lo hago para no tener muchas instancias de model mapper, solamente creo una y la llamo desde cualquier lado
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }

}
