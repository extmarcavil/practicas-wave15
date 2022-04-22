package com.ejercicio.covid.service;

import com.ejercicio.covid.dtos.PersonaDTO;
import com.ejercicio.covid.dtos.SintomaDTO;
import com.ejercicio.covid.enums.NivelGravedad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidServiceImpl implements  CovidService{


    List<SintomaDTO> getSintomasDTOList(){
        List<SintomaDTO> sintomaDTOList = new ArrayList<>();
        sintomaDTOList.add(new SintomaDTO(1, "DOLOR_GARGANTA", NivelGravedad.REGULAR.name()));
        sintomaDTOList.add(new SintomaDTO(1, "PERDIDA_OLFATO", NivelGravedad.CONTROLADO.name()));
        sintomaDTOList.add(new SintomaDTO(1, "BRONQUITIS", NivelGravedad.CRITICO.name()));
        sintomaDTOList.add(new SintomaDTO(1, "FIEBRE", NivelGravedad.REGULAR.name()));
        sintomaDTOList.add(new SintomaDTO(1, "PERDIDA_DE_MOVILIDAD", NivelGravedad.CRITICO.name()));
        sintomaDTOList.add(new SintomaDTO(1, "DOLOR_EN_PECHO", NivelGravedad.CRITICO.name()));
        sintomaDTOList.add(new SintomaDTO(1, "DIARREA", NivelGravedad.REGULAR.name()));

        return sintomaDTOList;
    }
    List<PersonaDTO> getPersonaDTOList(){
        List<PersonaDTO> personaDTOList = new ArrayList<>();

        List <SintomaDTO> lista1 =  getSintomasDTOList().stream().filter( s -> s.getNombre().equals("DOLOR_GARGANTA")).collect(Collectors.toList());
        List <SintomaDTO> lista2 = getSintomasDTOList().stream().filter( s -> s.getNombre().equals("FIEBRE")).collect(Collectors.toList());
        List <SintomaDTO> lista3 = getSintomasDTOList().stream().filter( s -> s.getNombre().equals("BRONQUITIS")).collect(Collectors.toList());
        List <SintomaDTO> lista4 = getSintomasDTOList().stream().filter( s -> s.getNombre().equals("DIARREA")).collect(Collectors.toList());
        List <SintomaDTO> lista5 =  getSintomasDTOList().stream().filter( s -> s.getNombre().equals("DIARREA")).collect(Collectors.toList());
        personaDTOList.add(new PersonaDTO( "Fernando", "Alonso", 78, lista1));
        personaDTOList.add(new PersonaDTO( "Fernando", "Alonso", 78, lista2));
        personaDTOList.add(new PersonaDTO( "Maria", "Fernandez", 61, lista3));
        personaDTOList.add(new PersonaDTO( "Carlos", "Bilardo",90, lista3));
        personaDTOList.add(new PersonaDTO("Pedro", "Esposito", 56, lista3));
        personaDTOList.add(new PersonaDTO("Pablo", "Rodriguez", 42, lista4));
        personaDTOList.add(new PersonaDTO( "Facundo", "Cardenas", 24, lista5));
        personaDTOList.add(new PersonaDTO( "Rodolfo", "Arruabarrena", 89, lista4));
        personaDTOList.add(new PersonaDTO( "Santiago", "Laramirno", 11, lista5));
        personaDTOList.add(new PersonaDTO( "Adrian", "Insua", 55, lista1));

        return personaDTOList;
    }

    @Override
    public List<SintomaDTO> findSymptom() {
        return getSintomasDTOList();
    }

    @Override
    public String findSymptomByName(String nombre) {
        SintomaDTO sintomaNew = new SintomaDTO();
        List<SintomaDTO>  sintomaList =  getSintomasDTOList();
        for (SintomaDTO s: sintomaList) {
               if(s.getNombre().equals(nombre)){
                   sintomaNew = s;
               }
        }
        return sintomaNew.getNivelGravedad();
    }

    public List<PersonaDTO> findRiskPerson(){
        List<PersonaDTO> personaDTOListResult = getPersonaDTOList();
        personaDTOListResult.removeIf(p -> p.getEdad() < 60 );

        return personaDTOListResult;
    }
}
