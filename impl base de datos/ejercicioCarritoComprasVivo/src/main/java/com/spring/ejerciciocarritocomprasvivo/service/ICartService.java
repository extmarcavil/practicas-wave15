package com.spring.ejerciciocarritocomprasvivo.service;

import com.spring.ejerciciocarritocomprasvivo.dto.CartDTO;

import java.util.List;

public interface ICartService {
    CartDTO saveCart(CartDTO cartDTO);

    List<CartDTO> listAll();

    void deleteCart(Long id);
}
