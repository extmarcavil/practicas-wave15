package com.apicovid19.dtos;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class SintomaDTO implements Serializable {
    private  int codigo;

    public  String nombre;

    private  int nivelgravedad;
}
