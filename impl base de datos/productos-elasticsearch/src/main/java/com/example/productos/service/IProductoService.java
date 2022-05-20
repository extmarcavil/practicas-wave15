package com.example.productos.service;

import com.example.productos.domain.Producto;

import java.util.List;

public interface IProductoService {
    Producto save(Producto producto);

    List<Producto> findAll();
}
