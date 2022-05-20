package ar.com.alehenestroza.nosqlempleados.controller;

import ar.com.alehenestroza.nosqlempleados.dto.request.NewEmpleadoDTO;
import ar.com.alehenestroza.nosqlempleados.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    final EmpleadoService empleadoService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(empleadoService.getAll());
    }

    @PostMapping("/new")
    public ResponseEntity<?> save(@RequestBody NewEmpleadoDTO newEmpleadoDTO) {
        return ResponseEntity.ok(empleadoService.save(newEmpleadoDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody NewEmpleadoDTO empleadoDTO, @PathVariable String id) {
        return ResponseEntity.ok(empleadoService.update(id, empleadoDTO));
    }
}
