package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.ReqPostJoyaDto;
import com.bootcamp.joyeria.dto.ResPostMessageDto;
import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    private IJoyaService service;

    public JoyaController(IJoyaService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<ResPostMessageDto> crearJoya(@RequestBody ReqPostJoyaDto joya){
        return new ResponseEntity<>(service.saveJoya(joya), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Joya>> obtenerJoyas(){
        return new ResponseEntity<>(service.getJoyas(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResPostMessageDto> borrarJoya(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteJoya(id), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> modificarJoya(@PathVariable Long id, @RequestBody ReqPostJoyaDto joya){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateJoya(id, joya));
    }
}
