package com.apideportistas.controllers;

import com.apideportistas.model.Deporte;
import com.apideportistas.services.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeporteController {

    @Autowired
    private IDeporteService _deporteService;


    //region End Points
    @PostMapping("/deporte")
    public int agregarDeporte(@RequestBody Deporte deporte) {
        try{
            return _deporteService.agregarDeporte(deporte);
        }
        catch (Exception e){
            throw  e;
        }
    }

    @GetMapping("/deporte/findsports")
    public ResponseEntity<ArrayList<Deporte>> verDeportes() {
        try{
            return new ResponseEntity<>(_deporteService.obtenerDeportes(),HttpStatus.OK);
        }
        catch (Exception e){
            throw  e;
        }
    }

    @GetMapping("/deporte/findsports/{nombreDeporte}")
    public ResponseEntity<Deporte> buscarDeporte(@PathVariable String nombreDeporte) throws Exception {
        try{
            return new ResponseEntity(_deporteService.deportebyNombre(nombreDeporte),HttpStatus.OK);
        }
        catch (Exception e){
            throw  e;
        }
    }

    @GetMapping("/deporte/findsportID/{idDeporte}")
    public ResponseEntity<Deporte> buscarDeporte(@PathVariable int idDeporte) throws Exception {
        try{
            return new ResponseEntity(_deporteService.deportebyId(idDeporte),HttpStatus.OK);
        }
        catch (Exception e){
            throw  e;
        }
    }
    //endregion
}
