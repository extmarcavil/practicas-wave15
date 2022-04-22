package com.covid.covid.repositorio;

import com.covid.covid.dto.PersonaDTO;
import com.covid.covid.dto.SintomaDTO;
import java.util.ArrayList;

public interface IRepositorioSintoma {
    ArrayList<SintomaDTO> getTodosLosSintomas();
    SintomaDTO getObtenerSintomaPorNombre(String nombre);
    ArrayList<PersonaDTO> getTodasLasPersonas();
}
