package com.mercadolibre.fp_be_java_hisp_w15_g05.model;

import lombok.Getter;

@Getter
public enum RolE {
    BUYER("BUYER"), REP("REP");

    String text;

    RolE(String text) {
        this.text = text;
    }
}
