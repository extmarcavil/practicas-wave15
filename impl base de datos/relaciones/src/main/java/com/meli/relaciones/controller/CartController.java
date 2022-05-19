package com.meli.relaciones.controller;

import com.meli.relaciones.dto.CartDto;
import com.meli.relaciones.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<CartDto> newCart (@RequestBody CartDto cartDto){
        return ResponseEntity.ok().body(service.saveCart(cartDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CartDto>> getAllCarts(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable Long id){
        service.delete(id);
    }

}
