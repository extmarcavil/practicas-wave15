package com.be.java.hisp.w156.be.java.hisp.w156.adapter;

import com.be.java.hisp.w156.be.java.hisp.w156.exception.LocalDateInvalidException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JsonAdapterDeserializer extends JsonDeserializer<LocalDate> {

    private final DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        try {
            return LocalDate.parse(jsonParser.getValueAsString(), formatter);
        } catch (DateTimeException ignore) {
            throw new LocalDateInvalidException();
        }
    }
}
