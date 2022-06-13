package com.mercadolibre.fp_be_java_hisp_w15_g05.model;

import lombok.Getter;

@Getter
public enum SectionTypeE {
    FRESH("FRESH"), FROZEN("FROZEN"), REFRIGERATED("REFRIGERATED"), OTHER("OTHER");

    String text;

    SectionTypeE(String text) {
        this.text = text;
    }


    public static SectionTypeE getSectionTypeBetween(Double temperature) {
        if(temperature > 5 && temperature <= 15)
            return SectionTypeE.FRESH;
        if(temperature >= -4 && temperature <= 5)
            return SectionTypeE.REFRIGERATED;
        if(temperature >= -25 && temperature <= -5)
            return SectionTypeE.FROZEN;
        return SectionTypeE.OTHER;
    }
}
