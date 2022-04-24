package com.Spring.Covid19.service;

import com.Spring.Covid19.dto.PersonaSintomaDTO;
import com.Spring.Covid19.dto.SintomaDTO;

import java.util.List;

public interface ICovid19Service {
    List<SintomaDTO> listarSintomas();
    SintomaDTO listarSintomaPorNombre(String nombre);
    List<PersonaSintomaDTO> listarSintomaticos();
}
