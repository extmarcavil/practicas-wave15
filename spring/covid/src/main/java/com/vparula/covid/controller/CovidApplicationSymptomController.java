package com.vparula.covid.controller;

import com.vparula.covid.dto.SintomasDTO;
import com.vparula.covid.entidades.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@RestController

@RequestMapping("/findSymptom")
public class CovidApplicationSymptomController {
    @GetMapping("/")
    public List<SintomasDTO> getSintomas(){
        List<SintomasDTO> sintomas = new ArrayList<>();
        for (Sintoma sin:sintoma) {
            sintomas.add(new SintomasDTO(sin.getCodigo(),sin.getNombre(),sin.getNivel_de_gravedad()));
        }

        return sintomas;

    }
    @GetMapping("/{name}")
    public ResponseEntity<String> getSintomas(@PathVariable String name){
        boolean encontre = false;

        Sintoma sint =sintoma.stream()
                .filter(s->s.getNombre()
                        .equals(name))
                .findFirst()
                .orElse(null);
        String nivel = null;
        if (sint != null){
            nivel= sint.getNivel_de_gravedad();
        }
        return new ResponseEntity<>(nivel, HttpStatus.OK);

    }




    public static List<Sintoma> sintoma = new ArrayList<>();
    static {
       sintoma.add(new Sintoma(1,"Fiebre","Grave"));
       sintoma.add(new Sintoma(2,"Resfrio","Moderado"));
       sintoma.add(new Sintoma(3,"Dolor de garganta","No tan grave"));
       sintoma.add(new Sintoma(4,"Cansancio","Moderado"));
       sintoma.add(new Sintoma(5,"Dolor de cabeza","Leve"));

    }
}
