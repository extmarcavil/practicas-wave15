package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    private IJoyaService service;

    @PostMapping("/jewerly/new")
    public String saveJoya (@RequestBody Joya joya) {
        return service.saveJoya(joya);
    }

    @GetMapping("/jewerly")
    public List<Joya> getJoyas () {
        return service.getJoyas();
    }

    @PutMapping("/jewerly/delete/{id}")
    public String deleteJoya (@PathVariable Long id) {
        return service.deleteJoya(id);
    }

    @PutMapping ("/jewerly/update/{id}")
    public String editJoya (@PathVariable Long id, @RequestBody Joya joya) {
        return service.editJoya(id, joya);
    }

}
