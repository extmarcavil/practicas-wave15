package com.example.crudjoyeria.controller;

import com.example.crudjoyeria.model.Joya;
import com.example.crudjoyeria.service.IJoyeriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyeriaController {
    private final IJoyeriaService serv;

    public JoyeriaController(IJoyeriaService serv) {
        this.serv = serv;
    }

    //Se que hay que usar DTO, pero considere que era mas apropiado invertir el tiempo en el desarrollo del mapeo que es a lo que enfoca el ejercicio
    @PostMapping("/jewerly/new")
    public ResponseEntity<?> saveJoya (@RequestBody Joya joya) {
        return ResponseEntity.ok("id: " + serv.saveJoya(joya).getId().toString());
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<Joya>> getJoyas () {
        return ResponseEntity.ok(serv.getJoyas());
    }

    //como es un borrado lógico, uso el put
    @PutMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteJoya (@PathVariable Long id) {
        serv.deleteJoya(id);
        return ResponseEntity.ok("");
    }

    @PutMapping ("/jewerly/update/{id_modificar}")
    public ResponseEntity<Joya> updateJoya (@PathVariable Long id_modificar, @RequestBody Joya joya) {
        return ResponseEntity.ok(serv.updateJoya(id_modificar, joya));
    }
}
