package com.mercadolibre.fp_be_java_hisp_w15_g06.adapter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@JsonComponent
public class LocalDateAdapterSerializer extends JsonSerializer<LocalDate> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public void serialize(LocalDate date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String dateString = date.format(formatter);
        jsonGenerator.writeString(dateString);
    }
}
