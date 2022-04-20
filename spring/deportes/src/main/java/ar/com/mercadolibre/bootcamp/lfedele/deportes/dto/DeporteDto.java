package ar.com.mercadolibre.bootcamp.lfedele.deportes.dto;

import ar.com.mercadolibre.bootcamp.lfedele.deportes.model.Deporte;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeporteDto {
    private String nombre;

    public DeporteDto() {}

    public DeporteDto(Deporte deporte) {
        this.nombre = deporte.getNombre();
    }
}
