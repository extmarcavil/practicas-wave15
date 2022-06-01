package com.bootcamp.empleados.repository;

import com.bootcamp.empleados.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {

    @Override
    List<Employee> findAll();
}
