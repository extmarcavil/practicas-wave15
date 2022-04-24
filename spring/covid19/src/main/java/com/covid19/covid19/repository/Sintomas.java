package com.covid19.covid19.repository;

import com.covid19.covid19.dto.SintomaDTO;
import com.covid19.covid19.model.Sintoma;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class Sintomas {
    private List<Sintoma> sintomas;

    public Sintomas() {
        sintomas = new ArrayList<>();
        sintomas.add(new Sintoma("1","Fiebre",3));
        sintomas.add(new Sintoma("2","Asintomatico",0));
        sintomas.add(new Sintoma("3","Diarrea",4));
        sintomas.add(new Sintoma("4","Tos",2));
        sintomas.add(new Sintoma("5","Dificultad respiratoria",5));
        sintomas.add(new Sintoma("6","Perdida de olfato",1));
        sintomas.add(new Sintoma("7","Perdida de gusto",1));


    }

    public Optional<Sintoma> buscarSintoma(String nombreSintoma){
        return sintomas.stream().filter(s -> s.getNombre().equals(nombreSintoma)).findFirst();
    }
}
