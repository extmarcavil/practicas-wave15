package com.spring.calculadoraCalorias.service;

import com.spring.calculadoraCalorias.dto.PlatoDTO;
import com.spring.calculadoraCalorias.model.Ingrediente;
import com.spring.calculadoraCalorias.model.Plato;
import com.spring.calculadoraCalorias.repository.CalculadoraCaloriasImpl;
import com.spring.calculadoraCalorias.repository.CalculadoraCaloriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraCaloriasServiceImpl implements CalculadoraCaloriasService {

    @Autowired
    private CalculadoraCaloriasRepository repository;

    public PlatoDTO getPlato(String name, double peso) {
        Plato plato = repository.getPlato(name, peso);

        double totalCalorias = 0;
        Ingrediente ingredienteMayorCalorias = new Ingrediente();

        for(Ingrediente ingrediente: plato.getIngredientes()){
            double calorias = ingrediente.getCalories();

            if (calorias > ingredienteMayorCalorias.getCalories()) ingredienteMayorCalorias = ingrediente;

            totalCalorias += calorias;
        }


        return new PlatoDTO(totalCalorias, plato.getIngredientes(), ingredienteMayorCalorias);
    }
}
