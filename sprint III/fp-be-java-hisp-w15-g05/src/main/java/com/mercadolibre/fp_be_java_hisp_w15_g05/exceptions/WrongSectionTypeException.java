package com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions;

import org.springframework.http.HttpStatus;

public class WrongSectionTypeException extends ApiException{

    public WrongSectionTypeException(String message){
        super("bad_request",message, HttpStatus.BAD_REQUEST.value());
    }
}
