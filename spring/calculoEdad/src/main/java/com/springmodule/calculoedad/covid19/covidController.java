package com.springmodule.calculoedad.covid19;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class covidController {
    private List<Sintoma> sintomas = new ArrayList<Sintoma>(){{
        add(new Sintoma(123, "Tos", 2));
        add(new Sintoma(12345, "Congestión", 4));
        add(new Sintoma(123456, "Dolor de garganta", 5));
    }};

    @GetMapping("/findSymptom")
    public List<SintomaDTO> getAllSymptoms(){
        List<SintomaDTO> result = new ArrayList<>();
        for (Sintoma sint : sintomas){
            SintomaDTO sintDto = new SintomaDTO(sint);
            result.add(sintDto);
        }
        return result;
    }

    @GetMapping("/findSymptom/{name}")
    public SintomaDTO getSymptom(@PathVariable String name){
        for (Sintoma sint : sintomas){
            if (sint.getNombre().equals(name)){
                return new SintomaDTO(sint);
            }
        }
        return null;
    }
}
