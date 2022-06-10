package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
/* si hay un campo que queda vacio porque no se usa
 * entonces se ignora en la respuesta
 * */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorDTO {
    String name;
    String message;

    List<String> listErrors;

    HashMap<String, List<String>> errors;
    public ErrorDTO ( String name, String message ) {
        this.name    = name;
        this.message = message;
    }

    public ErrorDTO ( String name, List<String> listErrors ) {
        this.name       = name;
        this.listErrors = listErrors;
    }

    public ErrorDTO ( String name, HashMap<String, List<String>> errors ) {
        this.name         = name;
        this.errors       = errors;
    }
}
