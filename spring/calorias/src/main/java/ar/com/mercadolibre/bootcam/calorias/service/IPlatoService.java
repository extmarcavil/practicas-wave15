package ar.com.mercadolibre.bootcam.calorias.service;

import ar.com.mercadolibre.bootcam.calorias.dto.request.PlatoRequestDTO;
import ar.com.mercadolibre.bootcam.calorias.dto.response.PlatoResponseDTO;
import ar.com.mercadolibre.bootcam.calorias.model.Ingrediente;

import java.util.List;

public interface IPlatoService {
    PlatoResponseDTO getDataPlato(PlatoRequestDTO dto);

    List<Ingrediente> findIngredientes(PlatoRequestDTO dto);

    Integer findCantidadTotalCalorias(PlatoRequestDTO dto);

    Ingrediente findIngredienteMayorCalorias(PlatoRequestDTO dto);
}
