package com.apicovid19.controllers;

import com.apicovid19.dtos.PersonaDTO;
import com.apicovid19.dtos.SintomaDTO;
import com.apicovid19.services.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/sintoma")
public class SintomaController {
    @Autowired
    private ISintomaService _sintomaService;

    //region end points
    @PostMapping
    public int agregarSintoma(@RequestBody SintomaDTO sintoma)
    {
        return _sintomaService.agregarSintoma(sintoma);
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<ArrayList<SintomaDTO>> getSintomas()
    {
        return new ResponseEntity<>(_sintomaService.buscarSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{nombreSintoma}")
    public ResponseEntity<SintomaDTO> getSintomaNombre(@PathVariable String nombreSintoma)
    {
        return new ResponseEntity<>(_sintomaService.sintomaNombre(nombreSintoma), HttpStatus.OK);
    }

    //endregion
}
