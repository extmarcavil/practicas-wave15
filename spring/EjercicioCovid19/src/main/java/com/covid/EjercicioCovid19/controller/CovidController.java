package com.covid.EjercicioCovid19.controller;

import com.covid.EjercicioCovid19.dto.SintomaDTO;
import com.covid.EjercicioCovid19.model.Sintoma;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CovidController {


    @GetMapping("/findSymptom")
    public List<SintomaDTO> listarSintomas(){
        List<SintomaDTO> sintomas = new ArrayList<>();
        sintomas.add(new SintomaDTO(1,"fiebre",10));
        sintomas.add(new SintomaDTO(2,"tos",2));
        sintomas.add(new SintomaDTO(3,"dolor de cuerpo",8));
        return sintomas;
    }
}
