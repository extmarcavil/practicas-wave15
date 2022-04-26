package dtoresponseentity.ejerpractico.covid19.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {

    private String nombre;
    @JsonProperty("nivel_de_gravedad")
    private String nivelDeGravedad;


}
