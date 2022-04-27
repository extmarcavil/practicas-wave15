package com.be.java.hisp.w156.be.java.hisp.w156.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class SpringConfig {

    public ObjectMapper getObjectMapper(){
        return new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                //.registerModule(new JSR310Module())
                .registerModule(new JavaTimeModule());
    }

}
