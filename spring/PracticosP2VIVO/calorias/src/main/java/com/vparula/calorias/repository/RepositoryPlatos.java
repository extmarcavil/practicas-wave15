package com.vparula.calorias.repository;

import com.vparula.calorias.DTO.IngredienteDTO;
import com.vparula.calorias.model.Ingrediente;
import com.vparula.calorias.model.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RepositoryPlatos implements IRepository{
    List<Plato> platos;
    List<Ingrediente>  ingredientes;

    public RepositoryPlatos () {
        platos = new ArrayList<>();
        ingredientes   = new ArrayList<>();
        initData();
    }

    @Override
    public Optional<Plato> getCaloriasPlato (String plato) {
        
            List<Plato> platosFiltrados= platos.stream().filter(s -> s.getNombre().equals(plato)).collect(Collectors.toList());
            if(platosFiltrados.size()>0){
                return platosFiltrados.stream().findFirst();
            }else
                return null;


    }

    @Override
    public List<Ingrediente> getIngredientesPlato(String plato) {
        List<Plato> platoFiltrado = platos.stream().filter(s -> s.getNombre().equals(plato)).collect(Collectors.toList());
        if(platoFiltrado.size()>0){
            return platoFiltrado.stream().findFirst().get().getIngredientes();
        }else{
            return null;
        }
    }


    private void initData () {
        Ingrediente tomate   = new Ingrediente("Tomate",30);
        Ingrediente arroz   = new Ingrediente("Arroz",500);
        Ingrediente pollo   = new Ingrediente("Pollo",410);
        Ingrediente cebolla   = new Ingrediente("Cebolla",10);
        List<Ingrediente> listaS = new ArrayList<>();
        listaS.addAll(Arrays.asList(tomate,arroz ));
        List<Ingrediente> listaM = new ArrayList<>();
        listaM.addAll(Arrays.asList(pollo,arroz,cebolla,tomate));

        Plato plato = new Plato("Plato simple", 400, listaS);
        Plato plato2 = new Plato("Plato complejo", 800, listaM);

        this.platos.addAll(Arrays.asList(plato,plato2));
        this.ingredientes.addAll(Arrays.asList(pollo,cebolla,tomate,arroz));
    }
}
