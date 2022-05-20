package com.example.productos.service;

import com.example.productos.domain.Producto;
import com.example.productos.repository.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{
    private IProductoRepository productoRepository;

    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> productos = new ArrayList<>();
        productoRepository.findAll().forEach(productos::add);
        return productos;
    }
}
