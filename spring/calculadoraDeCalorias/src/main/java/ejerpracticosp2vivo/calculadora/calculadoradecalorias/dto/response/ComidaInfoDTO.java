package ejerpracticosp2vivo.calculadora.calculadoradecalorias.dto.response;

import ejerpracticosp2vivo.calculadora.calculadoradecalorias.dto.request.IngredienteDTO;
import lombok.Data;

import java.util.List;

@Data
public class ComidaInfoDTO {

    private Double cantidadTotalCalorias;
    private List<IngredienteDTO> ingredientes;
    private IngredienteDTO ingredienteConMayorCantidadCalorias;
}
