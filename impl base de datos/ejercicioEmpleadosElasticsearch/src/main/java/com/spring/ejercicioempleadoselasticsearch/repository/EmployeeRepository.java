package com.spring.ejercicioempleadoselasticsearch.repository;

import com.spring.ejercicioempleadoselasticsearch.domain.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    @Override
    List<Employee> findAll();

    Optional<Employee> findEmployeeByEdad(Integer edad);

    List<Employee> findAllByEdad(Integer edad);

    List<Employee> findAllByNameLike(String name);

}
