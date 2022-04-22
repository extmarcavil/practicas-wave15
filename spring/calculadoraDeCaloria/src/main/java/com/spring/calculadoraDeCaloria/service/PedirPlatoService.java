package com.spring.calculadoraDeCaloria.service;

import com.spring.calculadoraDeCaloria.DTO.response.InfoComidaDTO;
import com.spring.calculadoraDeCaloria.DTO.request.IngredientesClienteDTO;
import com.spring.calculadoraDeCaloria.DTO.response.IngredientesDTO;
import com.spring.calculadoraDeCaloria.repository.IIngredientesRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PedirPlatoService implements IPedirPlatoService{

    private IIngredientesRepository repo;

    public PedirPlatoService(IIngredientesRepository repo) {
        this.repo = repo;
    }

    private IngredientesDTO calcularCalorias (IngredientesClienteDTO ingrediente) {
        IngredientesDTO ingredienteDTO = null;
        repo.findIngredient(ingrediente.getName())
                .ifPresent(found -> ingredienteDTO
                        .setCalories(ingrediente
                                .getCantidad()*found.getCalories()));
        ingredienteDTO.setName(ingrediente.getName());
        return ingredienteDTO;
    }
    private int calcularTotalDeCalorias (List<IngredientesDTO> listaIngredientes) {
        int sumaTotal =  listaIngredientes.stream()
                .mapToInt(IngredientesDTO::getCalories)
                .sum();
        return sumaTotal;
    }

    @Override
    public InfoComidaDTO getInfoPlato(String name, int peso, List<IngredientesClienteDTO> listaIngredientes) {
        InfoComidaDTO result = new InfoComidaDTO();

        //creo la lista de ingredientes con sus calorias
        List<IngredientesDTO> listaResult = null;
        for(IngredientesClienteDTO ing : listaIngredientes){
            listaResult.add(this.calcularCalorias(ing));
        }
        result.setListaIgredientes(listaResult);

        //calcula la cantidad total de calorias
        int sumaTotalCalorias = this.calcularTotalDeCalorias(result.getListaIgredientes());
        result.setTotalCalorias(sumaTotalCalorias);

        listaResult.stream().sorted();
        result.setIngredienteMasCaloria(listaResult.get(0));

        return result;
    }

}
