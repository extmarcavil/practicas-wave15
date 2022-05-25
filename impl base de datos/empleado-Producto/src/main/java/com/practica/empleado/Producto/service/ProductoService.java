package com.practica.empleado.Producto.service;

import com.practica.empleado.Producto.dto.request.ProductoRequestDTO;
import com.practica.empleado.Producto.dto.response.ProductoResponseDTO;
import com.practica.empleado.Producto.entity.Producto;
import com.practica.empleado.Producto.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private final ProductoRepository repository;
    ModelMapper mapper;

    @Autowired
    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductoResponseDTO saveProducto(ProductoRequestDTO productoRequestDTO) {
        Producto producto = mapper.map(productoRequestDTO, Producto.class);
        repository.save(producto);
        return mapper.map(producto, ProductoResponseDTO.class);
    }

    public List<Producto> findAll() {
        return repository.findAll();
    }

    public List<Producto> findById(String id) {
        return repository.findById(id);
    }

    public List<Producto> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    public List<Producto> findByTipo(String tipo) {
        return repository.findByTipo(tipo);
    }
}
