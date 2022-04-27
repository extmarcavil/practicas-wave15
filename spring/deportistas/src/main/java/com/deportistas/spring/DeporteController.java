package com.deportistas.spring;


import com.deportistas.spring.entidades.Deporte;
import com.deportistas.spring.services.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DeporteController {

    @Autowired
    private DeporteService deporteService;

    @GetMapping("/findSports")
    public List<Deporte> findAllSports(){
        return  deporteService.getall();


    }


    @GetMapping("/findSport/{name}")
    public ResponseEntity<Integer> findSport(@PathVariable String name){
       Optional<Deporte> dep=  deporteService.getDeporte(name);
        System.out.println(dep.get().getNivel());
        ResponseEntity<Integer> integerResponseEntity = new ResponseEntity<Integer>(dep.get().getNivel(), HttpStatus.OK);
        return integerResponseEntity;


    }




}
