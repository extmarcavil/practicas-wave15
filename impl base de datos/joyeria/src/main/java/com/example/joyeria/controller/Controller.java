package com.example.joyeria.controller;


import com.example.joyeria.dto.request.ReqJoyaDTO;
import com.example.joyeria.dto.response.ResJoyaDTO;
import com.example.joyeria.service.JoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jewrly")
public class Controller {

    JoyaService service;

    Controller(JoyaService service){
        this.service = service;
    }

    //Crear una nueva joya y devolver el correspondiente status code
    // con un mensaje informando su “nro identificatorio”. (URI: /jewerly/new).
    @PostMapping("/new")
    public ResponseEntity<ResJoyaDTO>crearJoya(@RequestBody ReqJoyaDTO test){
        return new ResponseEntity<>(service.saveJoya(test), HttpStatus.OK);
    }



}
