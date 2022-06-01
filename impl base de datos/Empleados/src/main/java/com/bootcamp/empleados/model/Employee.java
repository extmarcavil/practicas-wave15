package com.bootcamp.empleados.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "empleado")
public class Employee {

    @Id
    private String id;
    private String name;
    private String surname;
    private Integer age;
    private String city;
    private String state;
}

