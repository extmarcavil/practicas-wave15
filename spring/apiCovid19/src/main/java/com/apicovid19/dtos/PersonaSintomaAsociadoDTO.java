package com.apicovid19.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class PersonaSintomaAsociadoDTO {
    private String nombre;

    private  String apellido;

    private ArrayList<SintomaDTO> listsintomas;
}
