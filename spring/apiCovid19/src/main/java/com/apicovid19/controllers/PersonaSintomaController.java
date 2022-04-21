package com.apicovid19.controllers;

import com.apicovid19.dtos.PersonaDTO;
import com.apicovid19.dtos.PersonaSintomaAsociadoDTO;
import com.apicovid19.dtos.PersonaSintomaDTO;
import com.apicovid19.services.ISintomaPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/personasintoma")
public class PersonaSintomaController {
    @Autowired
    private ISintomaPersonaService _sintomaPersonaService;

    //region end points
    @PostMapping
    public boolean agregarPersonaSintoma(@RequestBody PersonaSintomaDTO personaSintoma)
    {
        return _sintomaPersonaService.agregarSintomaPersona(personaSintoma);
    }

    @GetMapping
    public ResponseEntity<ArrayList<PersonaSintomaDTO>> getPersonasSintomas()
    {
        return new ResponseEntity<>(_sintomaPersonaService.personaSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson/{Edad}")
    public ResponseEntity<ArrayList<PersonaSintomaAsociadoDTO>> getPersonasSintomasEdad(@PathVariable int Edad)
    {
        return new ResponseEntity<>(_sintomaPersonaService.buscarPersonasSintomas(Edad), HttpStatus.OK);
    }
    //endregion
}
