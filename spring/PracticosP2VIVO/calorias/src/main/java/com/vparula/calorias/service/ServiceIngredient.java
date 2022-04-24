package com.vparula.calorias.service;

import com.vparula.calorias.DTO.IngredienteDTO;
import com.vparula.calorias.model.Ingrediente;
import com.vparula.calorias.model.Plato;
import com.vparula.calorias.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceIngredient implements IService{
    @Autowired
    IRepository repo;

    @Override
    public int getCalorias(String namePlato) {

        Optional<Plato> obj = repo.getCaloriasPlato(namePlato);
        if (obj!=null){
            Plato p = obj.get();
            return p.getIngredientes().stream().mapToInt(o -> o.getCalorias()).sum();
        }else return -1;


    }

    @Override
    public IngredienteDTO getIngredients(String namePlato) {
        List<Ingrediente> ingredientes =repo.getIngredientesPlato(namePlato);
        if(ingredientes!=null){

        }
    }
}
