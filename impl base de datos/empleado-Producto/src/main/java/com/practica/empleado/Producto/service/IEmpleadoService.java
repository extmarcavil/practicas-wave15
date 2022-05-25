package com.practica.empleado.Producto.service;

import com.practica.empleado.Producto.dto.request.EmpleadoRequestDTO;
import com.practica.empleado.Producto.dto.response.EmpleadoResponseDTO;
import com.practica.empleado.Producto.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {

    EmpleadoResponseDTO saveEmpleado(EmpleadoRequestDTO empleadoRequestDTO);

    List<Empleado> findAll();

    List<Empleado> findById(String id);

    List<Empleado> findByNombre(String nombre);

    List<Empleado> findByApellido(String apellido);

    List<Empleado> findAllByEdad(Integer edad);

}
