package com.ejercicio.ElasticSearchEmployees.repository;

import com.ejercicio.ElasticSearchEmployees.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    @Override
    List<Employee> findAll();

    Optional<Employee> findEmployeeByAgeGreaterThan(Integer age);
    List<Employee> findAllByAge(Integer age);

    /*    @Query("{\n" +
          "  \"query\": {\n" +
          "    \"multi_match\": {\n" +
          "      \"query\": \"?1\",\n" +
          "      \"fields\": [\"Nombre\", \"name\", \"Apellido\", \"lastname\"]\n" +
          "    }\n" +
          "  }\n" +
          "}")*/
    List<Employee> findAllByNameLike(String name);
}
