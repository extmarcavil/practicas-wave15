package com.example.joyeria.controller;

import com.example.joyeria.model.Joya;
import com.example.joyeria.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jewerly")
public class JoyaController {


    private final IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createJoya(@RequestBody Joya joya) {
        String response = joyaService.saveJoya(joya);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Joya>> getAllJoyas() {
        return ResponseEntity.ok(joyaService.getJoyas());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLogic(@PathVariable Long id) {
        return ResponseEntity.ok(joyaService.deleteJoya(id));
    }

    @PostMapping("/update")
    public ResponseEntity<Joya> update(@RequestBody Joya joya) {
        return ResponseEntity.ok(joyaService.update(joya));
    }


}
