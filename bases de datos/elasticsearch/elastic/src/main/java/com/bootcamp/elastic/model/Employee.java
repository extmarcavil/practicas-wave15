package com.bootcamp.elastic.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String city;
    private String departament;
}

