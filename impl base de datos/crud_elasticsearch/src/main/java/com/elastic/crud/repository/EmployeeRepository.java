package com.elastic.crud.repository;

import com.elastic.crud.model.Employee;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    @Override
    List<Employee> findAll();

    Optional<Employee> findEmployeeByAge(Integer age);

    List<Employee> findAllByAge(Integer age);


    /*@Query("{\n" +
            "  \"query\": {\n" +
            "    \"multi_match\": {\n" +
            "      \"query\": \"marco avila\",\n" +
            "      \"fields\": [\"Nombre\", \"name\", \"Apellido\", \"lastname\"]\n" +
            "    }\n" +
            "  }\n" +
            "}")*/
    List<Employee> findAllByNameLike(String name);
}
