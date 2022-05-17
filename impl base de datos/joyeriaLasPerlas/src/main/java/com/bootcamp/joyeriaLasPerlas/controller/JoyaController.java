package com.bootcamp.joyeriaLasPerlas.controller;

import com.bootcamp.joyeriaLasPerlas.model.Joya;
import com.bootcamp.joyeriaLasPerlas.service.IJoyaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    private final IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/jewerly/new")
    public String saveJoya (@RequestBody Joya joya) {
        return joyaService.saveJoya(joya);
    }

    @GetMapping("/jewerly")
    public List<Joya> getJoyas () {
        return joyaService.getJoyas();
    }

    @PutMapping("/jewerly/delete/{id}")
    public String deleteJoya (@PathVariable Long id) {
        return joyaService.deleteJoya(id);
    }


    @PutMapping ("/jewerly/update/{id}")
    public String editJoya (@PathVariable Long id, @RequestBody Joya joya) {
        return joyaService.editJoya(id, joya);
    }

}
