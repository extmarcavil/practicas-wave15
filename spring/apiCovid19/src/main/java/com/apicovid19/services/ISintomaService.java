package com.apicovid19.services;

import com.apicovid19.dtos.SintomaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ISintomaService {
    int agregarSintoma(SintomaDTO sintoma);

    ArrayList<SintomaDTO> buscarSintomas();

    SintomaDTO sintomaID(int idSintoma);

    SintomaDTO sintomaNombre(String Nombre);
}
