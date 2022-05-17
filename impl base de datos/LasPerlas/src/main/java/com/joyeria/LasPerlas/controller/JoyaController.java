package com.joyeria.LasPerlas.controller;

import com.joyeria.LasPerlas.model.Joya;
import com.joyeria.LasPerlas.service.IJoyaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    private final IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/jewerly/new")
    public String createJoya(@RequestBody Joya joya){
        joyaService.saveJoya(joya);
        return "Se agrego la joya " + joya.getNombre() + " con le numero identificatorio: " + joya.getNro_identificatorio() + ".";
    }

    @GetMapping("/jewerly")
    public List<Joya> getJoyas(){
        return joyaService.getJoyas();
    }

    @PostMapping("/jewerly/delete/{id_joya}")
    public String deleteJoya(@PathVariable long id_joya){
        joyaService.deleteJoya(id_joya);
        return "Se elimino la joya con le numero identificatorio: " + id_joya + ".";
    }

    @PostMapping("/jewerly/update/{id_joya}")
    public Joya editJoya(@PathVariable long id_joya,
                         @RequestParam ("nombre") String newName,
                         @RequestParam ("particularidad") String newParticularidad){
        Joya joya = joyaService.findJoya(id_joya);
        joya.setNombre(newName);
        joya.setParticularidad(newParticularidad);
        joyaService.saveJoya(joya);
        return joya;
    }

}
