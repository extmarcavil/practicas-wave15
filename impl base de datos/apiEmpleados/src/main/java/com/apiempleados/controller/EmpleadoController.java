package com.apiempleados.controller;

import com.apiempleados.dto.EmpleadoDTO;
import com.apiempleados.service.IEmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    private IEmpleadoService empleadoService;

    public EmpleadoController(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> nuevoEmpleado(@RequestBody EmpleadoDTO empleado){
        return ResponseEntity.ok(empleadoService.crear(empleado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> actualizaEmpleado(@PathVariable String id,
                                                         @RequestBody EmpleadoDTO empleado){
        return ResponseEntity.ok(empleadoService.actualizar(id,empleado));
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> todosEmpleados(){
        return ResponseEntity.ok(empleadoService.todosEmpleados());
    }
}
