package ar.com.mercadolibre.bootcam.calorias.dto.response;

import ar.com.mercadolibre.bootcam.calorias.model.Ingrediente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PlatoResponseDTO {
    private Integer cantidadTotalCalorias;
    private List<Ingrediente> ingredientes;
    private Ingrediente ingredienteMayorCalorias;
}
