package com.Spring.Deportistas.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaDTO implements Serializable {

    private String nombre;
    private String apellido;
    private int edad;
    List<DeporteDTO> deportes;

    public boolean practicaDeporte(){
        return !this.deportes.isEmpty();
    }
}
