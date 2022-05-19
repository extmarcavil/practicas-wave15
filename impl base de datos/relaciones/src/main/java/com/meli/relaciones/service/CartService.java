package com.meli.relaciones.service;

import com.meli.relaciones.dto.CartDto;

import java.util.List;

public interface CartService {

     CartDto saveCart(CartDto cart);

    List<CartDto> getAll();

    void delete(Long id);
}
