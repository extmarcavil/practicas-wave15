package com.apicovid19.dtos;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class PersonaDTO implements Serializable {

    //region Variables
    private int id;

    private String nombre;

    private String apellido;

    private int edad;

    //endregion


}
