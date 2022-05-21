package com.santiagopinzond.Joyeria.controller;

import com.santiagopinzond.Joyeria.dto.JoyaDto;
import com.santiagopinzond.Joyeria.dto.JoyaIdentificador;
import com.santiagopinzond.Joyeria.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyeriaController {

    public IJoyaService joyaService;

    public JoyeriaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/create_joya")
    public ResponseEntity<JoyaIdentificador> createJoya(@RequestBody JoyaDto joyaDto){
        return new ResponseEntity("Su numero identificador es " + String.valueOf(joyaService.createJoya(joyaDto)), HttpStatus.CREATED);
    }

    @GetMapping("/obtener_joyas")
    public ResponseEntity<List<JoyaDto>> GetAllJoyas(){
        return new ResponseEntity<>(joyaService.getAllJoyas(), HttpStatus.OK);
    }

    @DeleteMapping("/delete_joya/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable Long id){
        joyaService.deleteJoya(id);
        return new ResponseEntity<>("Joya Borrada", HttpStatus.OK);
    }

    @PutMapping("/update_joya/{id}")
    public ResponseEntity<JoyaDto> updateJoya(@PathVariable Long id, @RequestBody JoyaDto joya){
        return new ResponseEntity<>(joyaService.updateJoya(id, joya), HttpStatus.OK);
    }

}
