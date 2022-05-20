package ar.com.alehenestroza.nosqlempleados.service;

import ar.com.alehenestroza.nosqlempleados.dto.request.NewEmpleadoDTO;
import ar.com.alehenestroza.nosqlempleados.dto.response.EmpleadoDTO;
import ar.com.alehenestroza.nosqlempleados.dto.response.EmpleadosDTO;

public interface EmpleadoService {
    EmpleadosDTO getAll();
    EmpleadoDTO save(NewEmpleadoDTO newEmpleadoDTO);
    EmpleadoDTO update(String id, NewEmpleadoDTO empleadoDTO);
}
