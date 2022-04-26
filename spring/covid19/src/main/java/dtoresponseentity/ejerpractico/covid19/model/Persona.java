package dtoresponseentity.ejerpractico.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Sintoma> sintomas;
}
