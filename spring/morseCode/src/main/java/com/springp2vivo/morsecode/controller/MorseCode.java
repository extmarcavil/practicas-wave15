package com.springp2vivo.morsecode.controller;

import com.springp2vivo.morsecode.util.Traduccion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MorseCode {

    @GetMapping("/decodificar/{morse}")
    public ResponseEntity<String> decodificadorMorse(@PathVariable String morse){
        HashMap<String,String> diccionarioMorse = Traduccion.obtenerMorse();
        String[] codigo = morse.split(" ");

        String traduccion = Traduccion.devolverConversion(codigo, diccionarioMorse,"");
        if(traduccion!= null){
            return new ResponseEntity<>(traduccion, HttpStatus.OK);
        }else return new ResponseEntity<>("Parámetro incorrecto", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/codificar/{palabra}")
    public ResponseEntity<String> decodificadorASCII(@PathVariable String palabra){
        HashMap<String,String> diccionarioASCII = Traduccion.obtenerASCII();
        String[] codigo = palabra.split("");

        String traduccion = Traduccion.devolverConversion(codigo, diccionarioASCII," ");
        if(traduccion!= null){
            return new ResponseEntity<>(traduccion, HttpStatus.OK);
        }else return new ResponseEntity<>("Parámetro incorrecto", HttpStatus.BAD_REQUEST);

    }

}
