package com.youtuber.Blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Profile("dev")
@Configuration
public class GlobalConfig {

    @PostConstruct
    public void ini(){
        System.out.println("Iniciando el ambiente de DEV");
    }

}
