package com.example.hqlejerciciopractico.controller;

import com.example.hqlejerciciopractico.service.IAutosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RequestMapping("/autos")
@RestController
public class AutosController {
    private IAutosService autosService;

    public AutosController(IAutosService autosService) {
        this.autosService = autosService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAll(){
        return new ResponseEntity(autosService.getAllPatentes(), HttpStatus.OK);
    }

    @GetMapping("/all/makin")
    public ResponseEntity<List<String>> getAllMakingOrder(){
        return new ResponseEntity(autosService.getAllOrderMakin(), HttpStatus.OK);
    }
}
