package com.spring.ejerciciocarritocomprasvivo.controller;

import com.spring.ejerciciocarritocomprasvivo.dto.CartDTO;
import com.spring.ejerciciocarritocomprasvivo.service.ICartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private final ICartService cartService;

    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/save")
    public ResponseEntity<CartDTO> newCart(@RequestBody CartDTO cart) {
        return new ResponseEntity<>(cartService.saveCart(cart), HttpStatus.OK);
    }

    @GetMapping("/listCarts")
    public ResponseEntity<List<CartDTO>> listCarts() {
        return new ResponseEntity<>(cartService.listAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }
}
