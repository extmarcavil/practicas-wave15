package com.ejercicio.joyeria.controller;

import com.ejercicio.joyeria.dto.JoyaDTO;
import com.ejercicio.joyeria.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {

    private final IJoyaService joyaServ;
    public JoyaController(IJoyaService joyaServ) {
        this.joyaServ = joyaServ;
    }

    @PostMapping("/new")
    public ResponseEntity<String> saveJewel(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>("El identificador de la joya es: "+ joyaServ.saveJoya(joyaDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<JoyaDTO>> getAllJewels(){
        return new ResponseEntity<>(joyaServ.getJoyas(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJewel (@PathVariable Long id) {
        joyaServ.deleteJoya(id);
        return new ResponseEntity<>("Joya eliminada correctamente", HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<JoyaDTO> actualizarRegistroTest (@PathVariable Long id_modificar, @RequestBody JoyaDTO joyaDTO) {
        return new ResponseEntity<>(joyaServ.editJoya(id_modificar,joyaDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoyaDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(joyaServ.findJoya(id),HttpStatus.OK);
    }

}
