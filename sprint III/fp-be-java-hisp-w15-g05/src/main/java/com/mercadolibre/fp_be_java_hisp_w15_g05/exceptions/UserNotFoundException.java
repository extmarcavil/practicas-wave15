package com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException(){
        super("user_not_found", "User y/o contraseña incorrecto", 404);
    }
}
