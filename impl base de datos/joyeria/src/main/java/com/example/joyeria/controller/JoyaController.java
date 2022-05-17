package com.example.joyeria.controller;

import com.example.joyeria.model.Joya;
import com.example.joyeria.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    private final IJoyaService service;

    public JoyaController(IJoyaService service) {
        this.service = service;
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<Long> saveJoya(@RequestBody Joya joya){
        return new ResponseEntity<>(service.saveJoya(joya), HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<Joya>> getJoyas(){
        return new ResponseEntity<>(service.getJoyas(), HttpStatus.OK);
    }

    @PostMapping("/jewerly/update/{id}")
    public ResponseEntity<Joya> saveJoya(
            @PathVariable Long id,
            @RequestBody Joya joya
    ){
        return new ResponseEntity<>(service.updateJoya(id, joya), HttpStatus.OK);
    }

    @PostMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable Long id){
        service.deleteJoya(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
