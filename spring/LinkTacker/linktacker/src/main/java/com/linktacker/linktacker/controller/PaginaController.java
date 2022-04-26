package com.linktacker.linktacker.controller;

import com.linktacker.linktacker.dto.PaginaRequestDTO;
import com.linktacker.linktacker.dto.PaginaResponseDTO;
import com.linktacker.linktacker.service.IPaginaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpClient;

@RestController
public class PaginaController {
    IPaginaService paginaService;

    public PaginaController(IPaginaService paginaService){
        this.paginaService = paginaService;
    }

    @PostMapping("/crearPagina")
    public ResponseEntity<PaginaResponseDTO> crearPagina(@RequestBody PaginaRequestDTO paginaRequestDTO){
        return new ResponseEntity<>(paginaService.crearPagina(paginaRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public ModelAndView redireccionPagina(@PathVariable int id, @RequestParam("password") String password){
        return new ModelAndView("redirect:" + paginaService.redirectURL(id, password));
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<Integer> metricasPagina(@PathVariable int id){
        return new ResponseEntity<>(paginaService.visitasPaginas(id), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public boolean invalidarPagina(@PathVariable int id){
        return paginaService.deshabilitarPagina(id);
    }

    @PostMapping("/validate/{id}")
    public boolean validarPagina(@PathVariable int id){
        return paginaService.habilitarPagina(id);
    }

}
