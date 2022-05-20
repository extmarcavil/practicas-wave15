package com.example.empleados.repository;

import com.example.empleados.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
    Optional<Empleado> findEmpleadoByEdad(Integer edad);
    List<Empleado> findAllByEdad(Integer edad);
    List<Empleado> findAllByNombreLike(String nombre);
}
