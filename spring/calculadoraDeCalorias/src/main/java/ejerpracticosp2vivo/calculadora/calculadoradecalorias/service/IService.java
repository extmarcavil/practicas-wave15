package ejerpracticosp2vivo.calculadora.calculadoradecalorias.service;

import ejerpracticosp2vivo.calculadora.calculadoradecalorias.dto.request.IngredienteDTO;
import ejerpracticosp2vivo.calculadora.calculadoradecalorias.dto.response.ComidaInfoDTO;
import ejerpracticosp2vivo.calculadora.calculadoradecalorias.model.Ingrediente;

import java.util.List;

public interface IService {
    ComidaInfoDTO getInfoComida(List<IngredienteDTO> ingredientes);

}
