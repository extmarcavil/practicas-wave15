package com.mercadolibre.fp_be_java_hisp_w15_g06.util;

public enum Token {
    SECRET(System.getenv().get("SECRET_KEY_TOKEN"));

    private final String value;

    Token(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
