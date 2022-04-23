package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.PlatoMuestraDTO;
import com.example.calculadoracalorias.model.Ingrediente;
import com.example.calculadoracalorias.model.Plato;
import com.example.calculadoracalorias.repository.ICalculadoraCaloriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalculadoraCaloriasService implements ICalculadoraCaloriasService{
    @Autowired
    ICalculadoraCaloriasRepository repository;

    @Override
    public PlatoMuestraDTO getInfoPlato(String nombre, Integer peso) {
        Optional<Plato> plato = repository.getPlato(nombre);
        if (plato != null){
            Plato platoElegido = plato.get();
            PlatoMuestraDTO platoDto = new PlatoMuestraDTO(platoElegido.getNombre(), platoElegido.getIngredientes());
            platoDto.setCaloriasPlato(platoDto.getIngredientes().stream().
                                            map(x -> x.getCalories()).
                                            reduce(0, (a,b) -> a.intValue() + b.intValue()));
            int maximo = Integer.MIN_VALUE;
            for (Ingrediente i : platoDto.getIngredientes()){
                if (i.getCalories() > maximo){
                    platoDto.setCaloriasMaximas(i);
                    maximo = i.getCalories();
                }
            }
            return platoDto;
        } else {
            return null;
        }

    }
}
