package com.practica.empleado.Producto.repository;

import com.practica.empleado.Producto.entity.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends ElasticsearchRepository<Producto, Integer> {

    List<Producto> findAll();

    List<Producto> findById(String id);

    List<Producto> findByNombre(String nombre);

    List<Producto> findByTipo(String tipo);

}
