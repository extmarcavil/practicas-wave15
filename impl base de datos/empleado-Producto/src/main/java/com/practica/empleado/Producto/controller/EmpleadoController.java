package com.practica.empleado.Producto.controller;

import com.practica.empleado.Producto.dto.request.EmpleadoRequestDTO;
import com.practica.empleado.Producto.entity.Empleado;
import com.practica.empleado.Producto.service.IEmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    IEmpleadoService service;

    public EmpleadoController(IEmpleadoService service) {
        this.service = service;
    }

    @PostMapping("")
    public void saveEmpleado(@RequestBody EmpleadoRequestDTO empleado) {
        service.saveEmpleado(empleado);
    }

    @GetMapping()
    public List<Empleado> findAllEmpleado() {
        return service.findAll();
    }

    @GetMapping("id/{id}")
    public List<Empleado> findByIdEmpleado(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("{nombre}")
    public List<Empleado> findByNameEmpelado(@PathVariable String nombre) {
        return service.findByNombre(nombre);
    }

    @GetMapping("{apellido}")
    public List<Empleado> findByApellidoEmpelado(@PathVariable String apellido) {
        return service.findByApellido(apellido);
    }

    @GetMapping("/{edad}")
    public List<Empleado> findByEdadEmpelado(@PathVariable Integer edad) {
        return service.findAllByEdad(edad);
    }
}
