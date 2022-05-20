package com.example.segurosautos.controller;

import com.example.segurosautos.dto.SiniestroDTO;
import com.example.segurosautos.service.ISiniestroService;
import com.example.segurosautos.service.IVehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/siniestro")
public class SiniestroController {
    private final ISiniestroService siniestroService;

    public SiniestroController(ISiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @PostMapping()
    ResponseEntity<SiniestroDTO> newSiniestro(@RequestBody SiniestroDTO siniestroDTO){
        return ResponseEntity.ok(siniestroService.save(siniestroDTO));
    }
}
