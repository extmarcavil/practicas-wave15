package com.bootcamp.jewelry.controller;

import com.bootcamp.jewelry.dto.ReqJewelDTO;
import com.bootcamp.jewelry.dto.ResJewlDTO;
import com.bootcamp.jewelry.service.IJewelryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/jewelry")
public class JewelryController {

    private final IJewelryService jewelryService;

    public JewelryController(IJewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> saveJewel(@RequestBody ReqJewelDTO jewelDTO){
        return new ResponseEntity<>("El nro identificatorio es: "+ jewelryService.saveJewel(jewelDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ResJewlDTO>> getAllJewels(){
        return new ResponseEntity<>(jewelryService.getJewels(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJewel (@PathVariable Long id) {
        jewelryService.deleteJewel(id);
        return new ResponseEntity<>("Joya eliminada correctamente", HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<ResJewlDTO> actualizarRegistroTest (@PathVariable Long id_modificar, @RequestBody ReqJewelDTO jewelDTO) {
        return new ResponseEntity<>(jewelryService.updateJewel(id_modificar,jewelDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResJewlDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(jewelryService.findJewel(id),HttpStatus.OK);
    }

}