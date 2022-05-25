package com.joyeriaP.joyeriaP.controller;

import com.joyeriaP.joyeriaP.DTO.ResponseDTO;
import com.joyeriaP.joyeriaP.Exception.JewelryException;
import com.joyeriaP.joyeriaP.model.Jewelry;
import com.joyeriaP.joyeriaP.service.IJewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewelryController {

    @Autowired
    private IJewelryService jewelryService;

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> createJewerly(@RequestBody Jewelry jewelry){
       return ResponseEntity.status(HttpStatus.OK)
               .body(new ResponseDTO("The product with the id: " +jewelryService.saveJewelry(jewelry).getIdentity_number() + " was successfully created"));
    }

    @GetMapping
    public Collection<Jewelry> getAllJewelry(){
        return jewelryService.getAllJewelry();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteJewelry(@PathVariable Long id){
        jewelryService.deleteJewelry(id);
        return new ResponseEntity<>(new ResponseDTO("Successfully deleted!"),HttpStatus.OK);
    }


    @PostMapping("/update/{id}")
    public ResponseEntity<Jewelry> updateJewelry(@RequestBody Jewelry jewelry, @PathVariable Long id){
        return new ResponseEntity<>(jewelryService.updateJewelry(jewelry, id), HttpStatus.OK);

    }
}
