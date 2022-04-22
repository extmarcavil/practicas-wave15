package com.covid.covid.servicio;

import com.covid.covid.dto.*;
import java.util.ArrayList;

public interface ISintomaServicio {
    ArrayList<SintomaDTO> getListaSintoma();
    SintomaDTO obtenerSintoma(String nombre);
    ArrayList<PacienteDTO> obtenerPacientes();
}
