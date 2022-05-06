package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ObjectWriterFactory {
    public static ObjectWriter create() {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                .writer();
    }
}
