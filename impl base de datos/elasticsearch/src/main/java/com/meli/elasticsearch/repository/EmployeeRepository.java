package com.meli.elasticsearch.repository;

import com.meli.elasticsearch.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends GenericElasticsearchRepository<Employee> {

    List<Employee> findByName(String name);

}
