package com.practica.empleado.Producto.repository;

import com.practica.empleado.Producto.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadosRepository  extends ElasticsearchRepository<Empleado, Integer> {

        List<Empleado> findAll();

        List<Empleado> findById(String id);

        List<Empleado> findByNombre(String nombre);

        List<Empleado> findByApellido(String apellido);

        List<Empleado> findAllByEdad(Integer edad);
}
