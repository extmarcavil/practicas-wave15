package com.spring.calculadoraDeCaloria.DTO;

import com.spring.calculadoraDeCaloria.DTO.response.IngredientesDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ComidasDTO {
    private String name;
    private List<IngredientesDTO> ingredientes;

}
