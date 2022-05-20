package com.example.EjercicioJoyeria.controller;

import com.example.EjercicioJoyeria.model.Joya;
import com.example.EjercicioJoyeria.service.JoyaService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    JoyaService joyaService;

    public JoyaController(JoyaService joyaService){
        this.joyaService = joyaService;
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<String> create (@RequestBody Joya joya){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(joyaService.createJoya(joya));
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<Joya>> getJoyas(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(joyaService.listaJoyas());
    }

    @PostMapping("jewerly/delete/{id}")
    public ResponseEntity<String> deleteJoya(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(joyaService.deleteJoya(id));
    }

    @PutMapping("jewerly/update/{id}")
    public ResponseEntity<String> updateJoya(@PathVariable Long id, @RequestBody Joya joya){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(joyaService.updateJoya(id,joya));
    }


}
