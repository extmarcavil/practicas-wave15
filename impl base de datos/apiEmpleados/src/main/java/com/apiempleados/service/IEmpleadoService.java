package com.apiempleados.service;

import com.apiempleados.dto.EmpleadoDTO;

import java.util.List;

public interface IEmpleadoService {
    EmpleadoDTO crear(EmpleadoDTO empleado);

    EmpleadoDTO actualizar(String id,EmpleadoDTO empleado);

    List<EmpleadoDTO> todosEmpleados();
}
