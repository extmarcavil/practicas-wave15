package com.ejerciciodeportista.ejerciciodeportista.repository;

import com.ejerciciodeportista.ejerciciodeportista.dto.DeportistaDTO;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DeportistaRepositoryImpl implements DeportistaRepository{
    List<DeportistaDTO> listaDeportistas = new ArrayList<DeportistaDTO>();

    public DeportistaRepositoryImpl(){
        initData();
    }

    @Override
    public List<DeportistaDTO> listarDeportistas() {
        return listaDeportistas;
    }

    public void initData(){
        String deporte1 = "Futbol";
        String deporte2 = "Basket";
        String deporte3 = "Hockey";

        List<String> listaDeportes1 = new ArrayList<String>();
        listaDeportes1.add(deporte1);
        listaDeportes1.add(deporte2);

        List<String> listaDeportes2 = new ArrayList<String>();
        listaDeportes2.add(deporte3);
        listaDeportes2.add(deporte2);

        List<String> listaDeportes3 = new ArrayList<String>();
        listaDeportes3.add(deporte1);
        listaDeportes3.add(deporte3);

        DeportistaDTO deportista1 = new DeportistaDTO("Matias", "Alvarez", listaDeportes2);
        DeportistaDTO deportista2 = new DeportistaDTO("Florencia", "Tuninetti", listaDeportes1);
        DeportistaDTO deportista3 = new DeportistaDTO("Roberto", "Alvarez", listaDeportes3);

        listaDeportistas.add(deportista1);
        listaDeportistas.add(deportista2);
        listaDeportistas.add(deportista3);
    }

}
