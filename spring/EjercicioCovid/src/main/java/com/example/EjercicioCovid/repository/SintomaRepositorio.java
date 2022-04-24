package com.example.EjercicioCovid.repository;

import com.example.EjercicioCovid.dto.PacienteDTO;
import com.example.EjercicioCovid.dto.PersonaDTO;
import com.example.EjercicioCovid.dto.SintomaDTO;
import com.example.EjercicioCovid.model.Persona;
import com.example.EjercicioCovid.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SintomaRepositorio implements ISintomaRepositorio{

    public SintomaRepositorio(){
        sintomas = new ArrayList<>();
        persona = new ArrayList<>();
        initData();
    }

    ArrayList<SintomaDTO> sintomas;

    List<PersonaDTO> persona;

    private void initData(){
        SintomaDTO s1 = new SintomaDTO("s-01","Dolor de cabeza","Bajo");
        SintomaDTO s2 = new SintomaDTO("s-02","Fatiga", "Bajo");
        SintomaDTO s3 = new SintomaDTO("s-03","Fiebre", "Alto");
        SintomaDTO s4 = new SintomaDTO("s-04","Dolor de garganta", "Bajo");

        PersonaDTO p1 = new PersonaDTO("Thiago","Ramirez",21,Arrays.asList(s1,s2));
        PersonaDTO p2 = new PersonaDTO("Lola","Erbin",20,List.of(s4));
        PersonaDTO p3 = new PersonaDTO("Theo","Ramirez",11,new ArrayList<>());
        PersonaDTO p4 = new PersonaDTO("Tricia","Balderrama",61,Arrays.asList(s2,s3));
        PersonaDTO p5 = new PersonaDTO("Anti","Ramirez",53,List.of(s1));

        this.persona.addAll(Arrays.asList(p1,p2,p3,p4,p5));
        this.sintomas.addAll(Arrays.asList(s1,s2,s3,s4));
    }

    @Override
    public ArrayList<SintomaDTO> obtenerSintomas() {
        return sintomas;
    }


    @Override
    public SintomaDTO obtenerSintomaxNombre(String nombre) {
        SintomaDTO sintomaDTO = sintomas.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
        return sintomaDTO;
    }

    @Override
    public List<PersonaDTO> ObtenerPacientesRiesgo() {
        List<PersonaDTO> listaPacientesRiesgo = persona.stream()
                .filter(p -> p.getEdad() > 60 && p.getListaSintomas().isEmpty() == false).collect(Collectors.toList());
        return listaPacientesRiesgo;
    }


}
