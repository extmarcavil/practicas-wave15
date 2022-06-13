package com.mercadolibre.fp_be_java_hisp_w15_g05.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class ErrorDTO {
    private String message;
    private String type;
    private List<String> listErrors;
    private HashMap<String, List<String>> errorsMap;

    public ErrorDTO(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public ErrorDTO (String name, HashMap<String, List<String>> errors){
        this.message = name;
        this.errorsMap = errors;
    }
}
