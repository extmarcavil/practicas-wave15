package com.meli.obtenerdiploma.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Globals {
    public static String jsonFormat(Object objectSource) throws  Exception{
        var ObjectWritter = new ObjectMapper()
                .registerModule(new JavaTimeModule()) // convertir fechas
                .writer();
       return ObjectWritter.writeValueAsString(objectSource);
    }
}
