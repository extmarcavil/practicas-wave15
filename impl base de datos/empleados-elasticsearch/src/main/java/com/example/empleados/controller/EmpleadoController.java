package com.example.empleados.controller;

import com.example.empleados.domain.Empleado;
import com.example.empleados.dto.EmpleadoDTO;
import com.example.empleados.dto.EmpleadoRequestDTO;
import com.example.empleados.service.IEmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    private final IEmpleadoService empleadoService;

    public EmpleadoController(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }
    @PostMapping
    ResponseEntity<EmpleadoDTO> newEmpleado(@RequestBody EmpleadoRequestDTO empleado){
        return ResponseEntity.ok(empleadoService.save(empleado));
    }

    @GetMapping()
    ResponseEntity<List<EmpleadoDTO>> findAll(){
        return ResponseEntity.ok(empleadoService.findAll());
    }

    @GetMapping("/one")
    ResponseEntity<EmpleadoDTO> findEmpleadoByEdad(@RequestParam Integer edad){
        return ResponseEntity.ok(empleadoService.findByEdad(edad));
    }

    @GetMapping("/two")
    ResponseEntity<List<EmpleadoDTO>> findAllEmpleadosByEdad(@RequestParam Integer edad){
        return ResponseEntity.ok(empleadoService.findAllByEdad(edad));
    }

    @GetMapping("/three")
    ResponseEntity<List<EmpleadoDTO>> findAllEmpleadosByName(@RequestParam String nombre){
        return ResponseEntity.ok(empleadoService.findAllByNombreLike(nombre));
    }

    @DeleteMapping("/all")
    ResponseEntity<String> deleteAll(){
        return ResponseEntity.ok(empleadoService.deleteAll());
    }
}
