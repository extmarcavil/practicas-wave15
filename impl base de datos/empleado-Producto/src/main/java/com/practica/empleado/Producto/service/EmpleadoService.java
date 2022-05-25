package com.practica.empleado.Producto.service;

import com.practica.empleado.Producto.dto.request.EmpleadoRequestDTO;
import com.practica.empleado.Producto.dto.response.EmpleadoResponseDTO;
import com.practica.empleado.Producto.entity.Empleado;
import com.practica.empleado.Producto.repository.EmpleadosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService {

    private final EmpleadosRepository repository;
    ModelMapper mapper;

    @Autowired
    public EmpleadoService(EmpleadosRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmpleadoResponseDTO saveEmpleado(EmpleadoRequestDTO empleadoRequestDTO) {
        Empleado empleado = mapper.map(empleadoRequestDTO, Empleado.class);
        repository.save(empleado);
        return mapper.map(empleado, EmpleadoResponseDTO.class);
    }

    public List<Empleado> findAll() {
        return repository.findAll();
    }

    public List<Empleado> findById(String id) {
        return repository.findById(id);
    }

    public List<Empleado> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    public List<Empleado> findByApellido(String apellido) {
        return repository.findByApellido(apellido);
    }

    public List<Empleado> findAllByEdad(Integer edad) {
        return repository.findAllByEdad(edad);
    }

}
