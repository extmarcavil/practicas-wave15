package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.DTO.IngredientsClientDTO;
import com.example.calculadoracalorias.DTO.IngredientsDTO;
import com.example.calculadoracalorias.DTO.OrderDTO;
import com.example.calculadoracalorias.service.IOrderDishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderDish {
    private IOrderDishService service;
    @GetMapping("/RecepcionPlato/{name}/{weight}")
    public ResponseEntity<OrderDTO> orderDishPath(@PathVariable String name, @PathVariable double peso, @RequestBody List<IngredientsClientDTO> body){
        return new ResponseEntity<>(service.getDishInfo(name, peso, body), HttpStatus.OK);
    }
}
