package dtoresponseentity.ejerpractico.covid19.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {
    private String nombre;
    private String apellido;
    private List<SintomaDTO> sintomas;
}
