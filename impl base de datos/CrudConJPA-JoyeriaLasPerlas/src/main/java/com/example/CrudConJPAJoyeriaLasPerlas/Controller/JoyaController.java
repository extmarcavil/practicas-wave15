package com.example.CrudConJPAJoyeriaLasPerlas.Controller;

import com.example.CrudConJPAJoyeriaLasPerlas.Model.Joya;
import com.example.CrudConJPAJoyeriaLasPerlas.Service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    private final IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> createJoya(@RequestBody Joya joya){
        joyaService.saveJoya(joya);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<Joya>>showAllJoyas(){
        return new ResponseEntity<>(joyaService.getJoyas(),HttpStatus.OK);
    }

    @PutMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> venderJoya(@PathVariable int id){
        joyaService.deleteJoya(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<Joya> modificarJoya(@PathVariable int id_modificar, @RequestBody Joya joya){
        return new ResponseEntity<>(joyaService.updateJoya(id_modificar,joya),HttpStatus.OK);
    }
}
