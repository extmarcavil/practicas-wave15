package com.santiagopinzondev.Covid19;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PersonaSintomaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private Sintoma sintoma;

    }

