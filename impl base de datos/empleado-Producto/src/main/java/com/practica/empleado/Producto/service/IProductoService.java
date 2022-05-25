package com.practica.empleado.Producto.service;

import com.practica.empleado.Producto.dto.request.ProductoRequestDTO;
import com.practica.empleado.Producto.dto.response.ProductoResponseDTO;
import com.practica.empleado.Producto.entity.Producto;

import java.util.List;

public interface IProductoService {

    ProductoResponseDTO saveProducto(ProductoRequestDTO productoRequestDTO);

    List<Producto> findAll();

    List<Producto> findById(String id);

    List<Producto> findByNombre(String nombre);

    List<Producto> findByTipo(String tipo);

}
