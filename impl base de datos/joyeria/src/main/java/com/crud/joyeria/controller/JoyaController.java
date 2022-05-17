package com.crud.joyeria.controller;

import com.crud.joyeria.model.Joya;
import com.crud.joyeria.service.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    private JoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<String> add(@RequestBody Joya joya){
        joyaService.add(joya);
        return new ResponseEntity<>(" Creado correctamente , su numero identificatorio es : " + joya.getNro_identificatorio(), HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<Joya>> findAll(){
        return  new ResponseEntity<>( joyaService.listAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<String> updated (@PathVariable Long id_modificar){
        joyaService.update(id_modificar);
        return  new ResponseEntity<>("La joya ha sido modificado" ,  HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> delete(@PathVariable Long id){
        joyaService.delete(id);
        return new ResponseEntity<>("La joya con el id : " + id + " ha sido eliminada", HttpStatus.OK );
    }

}
