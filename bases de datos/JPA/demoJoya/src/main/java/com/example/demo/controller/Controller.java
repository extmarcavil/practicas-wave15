package com.example.demo.controller;

import com.example.demo.DTO.JoyaDTO;
import com.example.demo.DTO.JoyaRespDTO;
import com.example.demo.model.Joya;
import com.example.demo.service.IServiceJoya;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IServiceJoya serv;


    @PostMapping ("/jewerly/new")
    public ResponseEntity<Long> saveJoya (@RequestBody JoyaDTO joya) {

        return new ResponseEntity<>(serv.saveJoya(joya), HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<JoyaRespDTO>> getJoyas () {

        return new ResponseEntity<>(serv.getJoyas(),HttpStatus.OK);
    }

    @GetMapping("/jewerly/{id}")
    public ResponseEntity<JoyaRespDTO> getJoya (@PathVariable Long id) {

        return new ResponseEntity<>(serv.findJoya(id),HttpStatus.OK);
    }


    @PutMapping("/jewerly/delete/{id}")
    public ResponseEntity<HttpStatus> deleteLogicoJoya (@PathVariable Long id) {

         serv.deleteJoyaLogico(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/{id}")
    public ResponseEntity<HttpStatus> deleteJoya (@PathVariable Long id) {

        serv.deleteJoya(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping ("/jewerly/update/{id_modificar}")
    public ResponseEntity<HttpStatus> editJoya (@PathVariable Long id_modificar,
                            @RequestBody JoyaDTO joya) {

        serv.editJoya(id_modificar, joya);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
