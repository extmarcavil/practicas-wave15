package com.mercadolibre.fp_be_java_hisp_w15_g06.enums;

import lombok.Getter;

@Getter
public enum UserType {
    BUYER("BUYER"), ADMIN("ADMIN");

    final String text;

    UserType(String text) {
        this.text = text;
    }
}
