package com.covid.covid.dto;

import lombok.*;
import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO implements Serializable {
    Long id;
    String nombre;
    String apellido;
    Integer edad;
    ArrayList<SintomaDTO> listaSintomas = new ArrayList<SintomaDTO>();

    public boolean tieneSintomas(){
        return !this.listaSintomas.isEmpty();
    }

    public boolean personaAdulta(){
        return edad >= 60;
    }
}
