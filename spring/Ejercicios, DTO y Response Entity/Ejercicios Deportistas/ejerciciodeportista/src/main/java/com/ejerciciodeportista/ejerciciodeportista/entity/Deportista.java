package com.ejerciciodeportista.ejerciciodeportista.entity;

import com.ejerciciodeportista.ejerciciodeportista.dto.DeporteDTO;
import java.util.List;

public class Deportista extends Persona{
    List<DeporteDTO> listaDeportesQueRealiza;

    public Deportista(String nombre, String apellido, int edad, List<DeporteDTO> listaDeportesQueRealiza){
        super(nombre, apellido, edad);
        this.listaDeportesQueRealiza = listaDeportesQueRealiza;
    }

    public List<DeporteDTO> getDeporteQueRealiza() {
        return listaDeportesQueRealiza;
    }

    public void setDeporteQueRealiza(List<DeporteDTO> listaDeportesQueRealiza) {
        this.listaDeportesQueRealiza = listaDeportesQueRealiza;
    }
}
