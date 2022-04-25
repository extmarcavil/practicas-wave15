package com.ejerciciodeportista.ejerciciodeportista.controller;

import com.ejerciciodeportista.ejerciciodeportista.dto.DeporteDTO;
import com.ejerciciodeportista.ejerciciodeportista.dto.DeportistaDTO;
import com.ejerciciodeportista.ejerciciodeportista.service.DeporteServicio;
import com.ejerciciodeportista.ejerciciodeportista.service.DeportistaServicio;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DeporteController {
    DeporteServicio deporteServicio;
    DeportistaServicio deportistaServicio;

    public DeporteController(DeporteServicio deporteServicio, DeportistaServicio deportistaServicio){
        this.deporteServicio = deporteServicio;
        this.deportistaServicio = deportistaServicio;
    }

    //Punto 1.
    @GetMapping("/findSports")
    public List<DeporteDTO> listarDeportes(){
        return deporteServicio.listarDeportes();
    }

    //Punto 2.
    @GetMapping("/findSports/{nombre}")
    public String buscarDeporte(@PathVariable String nombre){
        return deporteServicio.buscarDeporte(nombre);
    }


    //Punto 3.
    @GetMapping("/findSportsPersons")
    public List<DeportistaDTO> buscarDeportistas(){
        return deportistaServicio.listarDeportistas();
    }
}
