package com.example.empleados.service;

import com.example.empleados.dto.EmpleadoDTO;
import com.example.empleados.dto.EmpleadoRequestDTO;

import java.util.List;

public interface IEmpleadoService {

    EmpleadoDTO save(EmpleadoRequestDTO empleado);

    List<EmpleadoDTO> findAll();

    EmpleadoDTO findByEdad(Integer edad);

    List<EmpleadoDTO> findAllByEdad(Integer edad);

    List<EmpleadoDTO> findAllByNombreLike(String nombre);

    String deleteAll();
}
