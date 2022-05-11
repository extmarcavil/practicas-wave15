package com.meli.obtenerdiploma.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ObjectWriterFactory {

    public static ObjectWriter create() {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
    }

}
