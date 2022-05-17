package com.ejercicio.JoyeriaLasPerlas.controller;

import com.ejercicio.JoyeriaLasPerlas.model.Joya;
import com.ejercicio.JoyeriaLasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class JoyaController {

    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/jewerly/new")
    public String nuevaJoya (@RequestBody Joya joya){
        return joyaService.saveJoya(joya);
    }
    
    @GetMapping("/jewerly")
    public List<Joya> listarJoyas(){
        return joyaService.getJoyas();
    }
    
    @PutMapping("/jewerly/delete/{id}")
    public String eliminarJoya (@PathVariable Long id){
        return joyaService.deleteJoya(id);
    }

    @PutMapping("/jewerly/update/{id}")
    public String editarJoya (@PathVariable Long id, @RequestBody Joya joya){
        return joyaService.editJoya(id, joya);
    }

}
