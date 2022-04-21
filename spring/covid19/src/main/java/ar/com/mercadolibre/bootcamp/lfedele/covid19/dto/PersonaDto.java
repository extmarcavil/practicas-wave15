package ar.com.mercadolibre.bootcamp.lfedele.covid19.dto;

import ar.com.mercadolibre.bootcamp.lfedele.covid19.model.Persona;
import ar.com.mercadolibre.bootcamp.lfedele.covid19.model.Sintoma;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PersonaDto {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<String> sintomas;

    public static PersonaDto fromPersona(Persona persona) {
        PersonaDto dto = new PersonaDto();
        dto.setId(persona.getId());
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        dto.setEdad(persona.getEdad());
        dto.setSintomas(
                persona
                    .getSintomas()
                    .stream()
                    .map(Sintoma::getNombre)
                    .collect(Collectors.toList())
        );
        return dto;
    }
}
