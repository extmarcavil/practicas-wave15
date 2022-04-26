package dtoresponseentity.ejerpractico.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;


}
