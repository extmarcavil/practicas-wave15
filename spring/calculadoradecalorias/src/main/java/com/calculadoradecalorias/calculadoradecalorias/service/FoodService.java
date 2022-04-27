package com.calculadoradecalorias.calculadoradecalorias.service;

import com.calculadoradecalorias.calculadoradecalorias.dto.FoodDTO;
import com.calculadoradecalorias.calculadoradecalorias.dto.IngredientDTO;
import com.calculadoradecalorias.calculadoradecalorias.exception.NotFoudFood;
import com.calculadoradecalorias.calculadoradecalorias.exception.NotFoudIngrediente;
import com.calculadoradecalorias.calculadoradecalorias.repository.IFoodRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService implements IFoodService{

    IFoodRepo repoFood;
    ModelMapper mapper;

    public FoodService(IFoodRepo repoFood) {
        this.repoFood = repoFood;
        mapper = new ModelMapper();
    }

    @Override
    public FoodDTO findFood(String name) {
        return mapper
                .map(repoFood.findByName(name)
                .orElseThrow(()-> new NotFoudFood("El palto " + name + " no se encuentra en la base de datos"))
                        ,FoodDTO.class);
    }


    /**
     * @param name nombre del plato de comida
     * @param peso peso del plato de comida
     * @return se toma como base calorias iniciales 100 g luego se hace el calculo dependiendo del peso
     * del plato para que retorne las calorias con respecto al peso que se suministro. Si no se encuentra
     * el plato en la base de datos se retorna 0 como valor.
     */
    // Se puede modificar para que se busque solamente el plato y pedir el objeto en si como argumento
    //en los 3 metodos siguientes.  y realizar todo en el controlador.
    @Override
    public double totalCaloriesFood(String name, double peso){
        return findFood(name)
                .getIngredients()
                .stream()
                .map(i -> i.getCalories()).reduce(Integer::sum)
                .orElse(0)*(peso/100);
    }

    @Override
    public List<IngredientDTO> listIngredients (String name){
        return findFood(name).getIngredients()
                .stream()
                .map(i -> mapper.map(i,IngredientDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public IngredientDTO mostCaolires(String name){
        return mapper.map(findFood(name)
                .getIngredients()
                .stream()
                .max(Comparator.comparing(IngredientDTO::getCalories))
                .orElseThrow(()-> new NotFoudIngrediente("El ingrediente no se encontro en la base de datos"))
                ,IngredientDTO.class);
    }
}
