package com.ejercicio.calculadoracalorias.service;

import com.ejercicio.calculadoracalorias.dto.IngredienteDTO;
import com.ejercicio.calculadoracalorias.dto.PlatoDTO;
import com.ejercicio.calculadoracalorias.repository.IPlatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PlatoService implements  IPlatoService {
    private final IPlatoRepository platoRepository;

    public PlatoService(IPlatoRepository platoRepository){
        this.platoRepository = platoRepository;
    }

    @Override
    public List<IngredienteDTO> getAllIngredients(String query) {
        return platoRepository.findAllIngredients(query);
    }

    @Override
    public String statsPlato(String name) {
        Optional<PlatoDTO> platoDTO = Optional.ofNullable(loadPlato().stream().filter(p -> p.getNombre().equals(name)).findFirst().orElse(null));

        int calorias  = 0;
        int mayorCant = 0;
        String nombreIngredienteMasCalorias = "";

        IngredienteDTO ingredienteDTO  = null;
        List<IngredienteDTO> ingredienteDTOLista = platoDTO.get().getIngredientes();

        for(int i = 0; i< ingredienteDTOLista.size() ; i++){
            calorias = calorias + ingredienteDTOLista.get(i).getCalories();

            if (ingredienteDTOLista.get(i).getCalories() > mayorCant){

                 mayorCant  =  ingredienteDTOLista.get(i).getCalories();
                 nombreIngredienteMasCalorias = ingredienteDTOLista.get(i).getName();
            }

        }
      return platoDTO.toString() +
              "La mayor cantidad de calorias de un ingrediente es : " + mayorCant + " y es del ingrediente : " + nombreIngredienteMasCalorias +
              " . Las calorias del plato son: " +calorias;

        }
    public List<PlatoDTO> loadPlato() {
       return platoRepository.loadPlato();
    }
}
