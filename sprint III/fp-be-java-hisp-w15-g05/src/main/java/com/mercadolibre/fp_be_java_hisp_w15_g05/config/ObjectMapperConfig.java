package com.mercadolibre.fp_be_java_hisp_w15_g05.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.blackbird.BlackbirdModule;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Spring Application configuration class.
 * @see Configuration
 */
@Configuration
public class ObjectMapperConfig {

  private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

  /**
   * Creates a mapper for object serialization/deserialization.
   * @return The mapper to use.
   */
  @Bean
  @Primary
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new BlackbirdModule());
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    objectMapper.setDateFormat(sdf);
    return objectMapper;
  }

}
