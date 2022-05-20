package ar.com.alehenestroza.nosqlempleados.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
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
