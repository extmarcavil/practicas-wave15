package com.example.demo.controller;

import com.example.demo.dto.PersonaDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.PersonaService;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.logging.Logger;

@RestController
public class HelloRestController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/helloPerson")
    public ResponseEntity<ResponseDTO> helloWorld(@PathVariable String name){
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setName(name);
        return new ResponseEntity<>(personaService.crearRespuesta(personaDTO),HttpStatus.OK);
    }



    @GetMapping("/ejemplo/{name}/{lastname}")
    public String returnName (@PathVariable String name, @PathVariable String lastname){
        return "El nombre y apellido completo del consumidor es: "+ name+" "+lastname;
    }

    @GetMapping("/exceptionThrow")
    public ResponseEntity<ResponseDTO> ejemploExcepciones(){
        /*
        if(true){
            throw new NumberFormatException("formato incorrecto de parámetro");
        }*/
        return new ResponseEntity<>(personaService.llamarControllerAdvice(),HttpStatus.OK);
    }
/*
    @GetMapping("/ejemplo")
    public ResponseEntity<ResponseDTO> returnName2 (@RequestParam(required = false) String name, @RequestParam String lastname){

        PersonaDTO persona = new PersonaDTO(name,lastname);
        Service service = new Service();
        return new ResponseEntity<ResponseDTO>(service.crearRespuesta(persona), HttpStatus.OK);
    }
*/
    @PostMapping("/createPerson")
    public ResponseEntity<ResponseDTO> returnResponse(@RequestBody PersonaDTO persona){
        return new ResponseEntity<ResponseDTO>(personaService.crearRespuesta(persona), HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "motivo")
    @ExceptionHandler(NumberFormatException.class)
    public void numberFormatHandler(){
        //logger.log(Level.getLevel("ERROR"),"NumberFormatException!");
        System.out.println("error");
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "motivo")
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public void numberFormatHandler2(){
        //logger.log(Level.getLevel("ERROR"),"NumberFormatException!");
        System.out.println("error");
    }

}
