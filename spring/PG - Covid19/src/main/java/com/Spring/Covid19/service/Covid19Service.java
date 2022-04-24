package com.Spring.Covid19.service;

import com.Spring.Covid19.dto.PersonaSintomaDTO;
import com.Spring.Covid19.dto.SintomaDTO;
import com.Spring.Covid19.repository.ICovid19Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Covid19Service implements ICovid19Service{

    private ICovid19Repository repository;

    public Covid19Service(ICovid19Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<SintomaDTO> listarSintomas() {
        return repository.listarSintomas();
    }

    @Override
    public SintomaDTO listarSintomaPorNombre(String nombre) {
        try{
            SintomaDTO sintoma = repository.listarSintomaPorNombre(nombre)
                    .orElseThrow(() -> new RuntimeException("NO ENCONTRADO"));
            return sintoma;
        }catch (RuntimeException e){
            return new SintomaDTO(0, e.getMessage(), "ERROR");
        }
    }

    @Override
    public List<PersonaSintomaDTO> listarSintomaticos() {
        List<PersonaSintomaDTO> sintomaticos = repository.listarSintomaticos().stream()
                .map(sintom -> new PersonaSintomaDTO(sintom.getNombre(), sintom.getApellido(), sintom.getSintomas()))
                .collect(Collectors.toList());
        return sintomaticos;
    }
}
