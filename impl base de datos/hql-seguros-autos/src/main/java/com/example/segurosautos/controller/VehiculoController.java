package com.example.segurosautos.controller;

import com.example.segurosautos.dto.VehiculoPatenteDTO;
import com.example.segurosautos.dto.VehiculoPatenteYMarcaDTO;
import com.example.segurosautos.dto.VehiculoPatenteYMarcaYModeloDTO;
import com.example.segurosautos.dto.VehiculoSiniestroDTO;
import com.example.segurosautos.service.IVehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/registrados")
    ResponseEntity<List<VehiculoPatenteDTO>> getAllRegistrados(){
        return ResponseEntity.ok(vehiculoService.findAllPatente());
    }

    @GetMapping("/ordenados")
    ResponseEntity<List<VehiculoPatenteYMarcaDTO>> getAllOrdenados(){
        return ResponseEntity.ok(vehiculoService.findAllVehiculoPatenteAndMarca());
    }

    @GetMapping("/current-year")
    ResponseEntity<List<VehiculoPatenteDTO>> getAllMoreThan4RuedasAndCurrentYear(){
        return ResponseEntity.ok(vehiculoService.findVehiculoPatenteByCantRuedasAndCurrentYear());
    }

    @GetMapping("/big-cost")
    ResponseEntity<List<VehiculoPatenteYMarcaYModeloDTO>> getAllCostMoreThan10000(){
        return ResponseEntity.ok(vehiculoService.findByCostGreaterThan(10000D));
    }

    @GetMapping("/big-total-cost")
    ResponseEntity<VehiculoSiniestroDTO> getAllCostMoreThan10000AndTotal(){
        return ResponseEntity.ok(vehiculoService.findBySiniestroCostGreaterThanAndTotalCost(10000D));
    }
}
