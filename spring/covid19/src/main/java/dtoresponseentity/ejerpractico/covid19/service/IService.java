package dtoresponseentity.ejerpractico.covid19.service;

import dtoresponseentity.ejerpractico.covid19.dto.PacienteDTO;
import dtoresponseentity.ejerpractico.covid19.dto.SintomaDTO;

import java.util.List;

public interface IService {

    SintomaDTO buscarPorNombre(String nombre);
    List<SintomaDTO> listarSintomas();
    List<PacienteDTO> listarPacientesRiesgo();

}
