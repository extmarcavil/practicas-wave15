package com.meli.roman.model;

public enum RomanNumerals {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000);

    private final Integer value;

    RomanNumerals(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
