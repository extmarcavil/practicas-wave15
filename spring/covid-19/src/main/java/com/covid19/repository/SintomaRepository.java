package com.covid19.repository;

import com.covid19.dto.SintomaDTO;
import com.covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class SintomaRepository {

    public static List<Sintoma> listaSintoma = new ArrayList<>();
    static {
        listaSintoma.add(new Sintoma("tos", "tos", 2));
        listaSintoma.add(new Sintoma("resfriado", "resfriado", 2));
        listaSintoma.add(new Sintoma("dolor_de_cabeza", "dolor_de_cabeza", 1));
    }

    public List<SintomaDTO> findSymptom(){
        List<SintomaDTO> sintomas = new ArrayList<>();
        for (Sintoma sintoma : listaSintoma) {
            sintomas.add(new SintomaDTO(sintoma));
        }
        return sintomas;
    }

    public Sintoma findSymptomByName(String name){
        return listaSintoma.stream()
                .filter(sintoma -> sintoma.getNombre().equals(name))
                .findFirst()
                .orElse(null);
    }
}
