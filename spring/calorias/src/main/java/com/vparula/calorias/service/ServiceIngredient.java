package com.vparula.calorias.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vparula.calorias.DTO.IngredienteDTO;
import com.vparula.calorias.model.Ingrediente;
import com.vparula.calorias.model.Plato;
import com.vparula.calorias.repository.IRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceIngredient implements IService{
    ModelMapper mapper;
    IRepository repo;

    public ServiceIngredient(IRepository repo){
        this.repo = repo;
        this.mapper = new ModelMapper();
    }
    @Override
    public int getCalorias(String namePlato) {

        Plato p = repo.getCaloriasPlato(namePlato);
        if (p!=null){
            return p.getIngredientes().stream().mapToInt(o -> o.getCalorias()).sum();
        }else return -1;


    }

    @Override
    public List<IngredienteDTO> getIngredients(String namePlato) {
        List<Ingrediente> ingredientes =repo.getIngredientesPlato(namePlato);
        List<IngredienteDTO> ret = new ArrayList<>();
        if(ingredientes !=null) {
            ret = ingredientes.stream().map(ing -> mapper.map(ing, IngredienteDTO.class)).collect(Collectors.toList());
        }
        return ret;
    }

    @Override
    public IngredienteDTO getIngredienteCalorico(String namePlato) {
        List<Ingrediente> lista = repo.getIngredientesPlato(namePlato);
       if(lista!=null){
            Optional<Ingrediente> i = lista.stream().max(Comparator.comparing(Ingrediente::getCalorias));
            return mapper.map(i, IngredienteDTO.class);
        }else{return null;}
    }
}
