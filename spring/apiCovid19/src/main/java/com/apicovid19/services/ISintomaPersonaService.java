package com.apicovid19.services;

import com.apicovid19.dtos.PersonaSintomaAsociadoDTO;
import com.apicovid19.dtos.PersonaSintomaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ISintomaPersonaService {
    boolean agregarSintomaPersona(PersonaSintomaDTO personaSintoma);

    ArrayList<PersonaSintomaDTO> personaSintomas();

    ArrayList<PersonaSintomaAsociadoDTO> buscarPersonasSintomas(int Edad);
}
