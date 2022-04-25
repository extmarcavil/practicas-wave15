package com.vparula.concesionaria.controller;

import com.vparula.concesionaria.dto.AutoDTO;
import com.vparula.concesionaria.model.Auto;
import com.vparula.concesionaria.service.ServiceAuto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles/")
public class ConcesionariaApplicationController {

    ServiceAuto manejarAutos;

    public ConcesionariaApplicationController(ServiceAuto manejarAutos) {
        this.manejarAutos = manejarAutos;
    }

    @PostMapping
    public ResponseEntity<String> agregarAuto(@RequestBody Auto auto){
       manejarAutos.agregarAuto(auto);
        return new ResponseEntity<>("Se ha agregado el auto con exito", HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<AutoDTO>> listarAutos(){
        List<AutoDTO> autos = manejarAutos.getAutos();
        if(autos.size()>0)
            return new ResponseEntity<>(autos, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/dates")
    public ResponseEntity<List<AutoDTO>> listarEntreFechas(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date since, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date to){

        List<AutoDTO> autos = manejarAutos.getAutosFecha(since,to);
        if(autos.size()>0)
            return new ResponseEntity<>(autos, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<AutoDTO>> listarEntrePrecios(@RequestParam Double since, @RequestParam Double to){

        List<AutoDTO> autos = manejarAutos.getAutosPrecio(since,to);
        if(autos.size()>0)
            return new ResponseEntity<>(autos, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
