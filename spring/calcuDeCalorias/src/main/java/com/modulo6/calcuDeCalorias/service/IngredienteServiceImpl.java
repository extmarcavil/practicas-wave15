package com.modulo6.calcuDeCalorias.service;

import com.modulo6.calcuDeCalorias.dto.IngredienteDTO;
import com.modulo6.calcuDeCalorias.dto.PlatoDTO;
import com.modulo6.calcuDeCalorias.repository.IngredienteRepository;
import com.modulo6.calcuDeCalorias.repository.IngredienteRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class IngredienteServiceImpl implements IngredienteService {

    IngredienteRepository ingredienteRepository;

    public IngredienteServiceImpl(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    @Override
    public PlatoDTO caloriasPlato(String nombre, Double peso) {

        PlatoDTO plato = ingredienteRepository.plato(nombre, peso);
        List<IngredienteDTO> ip1 = new ArrayList<>();
        ip1 = plato.getIngredientes();

        Double cp1= Double.valueOf((ip1.stream().mapToInt(ingrediente -> ingrediente.getCalories()).sum()));
        cp1 = cp1*plato.getPeso()/100;

        plato.setCalorias(cp1);
        return plato;
    }

    @Override
    public List<IngredienteDTO> getAllIngredientePlato(String nombre, Double peso) {
        PlatoDTO plato = caloriasPlato(nombre, peso);
        return plato.getIngredientes();
    }

    @Override
    public IngredienteDTO getIngredienteMayorCal(String nombre, Double peso) {

        List<IngredienteDTO> ingredientes = getAllIngredientePlato(nombre, peso);
        IngredienteDTO ingMayorCal = ingredientes.get(0);
        for(IngredienteDTO i : ingredientes){
            if (i.getCalories() > ingMayorCal.getCalories()){
                ingMayorCal = i ;
            }
        }
        return ingMayorCal;
    }


}
