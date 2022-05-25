package com.practica.empleado.Producto.controller;

import com.practica.empleado.Producto.dto.request.ProductoRequestDTO;
import com.practica.empleado.Producto.entity.Producto;
import com.practica.empleado.Producto.service.IProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("producto/")
@RestController
public class ProductoController {

    IProductoService service;

    public ProductoController(IProductoService service) {
        this.service = service;
    }

    @PostMapping("")
    public void saveProducto(@RequestBody ProductoRequestDTO producto) {
        service.saveProducto(producto);
    }

    @GetMapping()
    public List<Producto> findAllProducto() {
        return service.findAll();
    }

    @GetMapping("id/{id}")
    public List<Producto> findByIdProducto(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("{nombre}")
    public List<Producto> findByNameProducto(@PathVariable String nombre) {
        return service.findByNombre(nombre);
    }

    @GetMapping("{tipo}")
    public List<Producto> findByTipoProducto(@PathVariable String tipo) {
        return service.findByTipo(tipo);
    }
}
