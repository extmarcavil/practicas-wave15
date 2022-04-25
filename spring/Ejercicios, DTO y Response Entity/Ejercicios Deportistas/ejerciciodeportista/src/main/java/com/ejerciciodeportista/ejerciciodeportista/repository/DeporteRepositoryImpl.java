package com.ejerciciodeportista.ejerciciodeportista.repository;

import com.ejerciciodeportista.ejerciciodeportista.dto.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepositoryImpl implements DeporteRepository{
    List<DeporteDTO> listaDeportes = new ArrayList<DeporteDTO>();

    public DeporteRepositoryImpl(){
        initData();
    }

    @Override
    public List<DeporteDTO> listarDeportes() {
        return listaDeportes;
    }

    @Override
    public String buscarDeporte(String nombre) {
        String nivel = " ";
        for(DeporteDTO deporte : listaDeportes){
            if(deporte.getNombre().equals(nombre)){
               nivel = deporte.getNivel();
               break;
            }
        }
        return nivel;
    }

    public void initData(){
        DeporteDTO deporte1 = new DeporteDTO("Futbol", "Nivel 1");
        DeporteDTO deporte2 = new DeporteDTO("Basket", "Nivel 3");
        DeporteDTO deporte3 = new DeporteDTO("Hockey", "Nivel 2");

        listaDeportes.add(deporte1);
        listaDeportes.add(deporte2);
        listaDeportes.add(deporte3);
    }
}
