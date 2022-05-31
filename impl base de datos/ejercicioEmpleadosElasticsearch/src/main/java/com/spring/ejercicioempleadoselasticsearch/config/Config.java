package com.spring.ejercicioempleadoselasticsearch.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.spring.ejercicioempleadoselasticsearch.repository")
public class Config {

    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration client = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
        return RestClients.create(client).rest();
    }


    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }

}
