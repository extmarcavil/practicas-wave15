package com.meli.joyeria.Controller;

import com.meli.joyeria.Model.Jewelry;
import com.meli.joyeria.Service.IJewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewelryController {

    // data
    @Autowired
    private IJewelryService service;

    // constructors

    @PostMapping ("/save")
    public ResponseEntity<Jewelry> saveJewelry(@RequestBody Jewelry jewelry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveJewelry(jewelry));
    }

    @GetMapping("/all")
    public ResponseEntity<List<?>> getAllJewelry () {
        return ResponseEntity.status(HttpStatus.OK).body(service.getJewelry());
    }

    @GetMapping("/find/{id}")
    public Jewelry getByIdJewelry (@PathVariable Long id) {
        return service.findJewelry(id);
    }

    @PostMapping("/delete/{id}")
    public List<?> deleteJewelry (@PathVariable Long id) {
        return service.deleteJewelry(id);
    }
}
