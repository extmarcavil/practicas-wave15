package com.deportistas.spring.services;

import com.deportistas.spring.entidades.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeporteService {

    public List<Deporte> getall(){
        Deporte deporte= new Deporte();
        List<Deporte> listaDeportes = deporte.getLista();


        return listaDeportes;
    }

    public Optional<Deporte> getDeporte(String name) {
        List<Deporte> listaDeportes = new ArrayList<>();
        listaDeportes.add(new Deporte("Futbol",2));
        listaDeportes.add(new Deporte("Tennis",1));

       Optional<Deporte> dep= listaDeportes.stream().filter(deporte -> deporte.getNombre().equalsIgnoreCase(name)).findFirst();

       return dep;
    }
}
