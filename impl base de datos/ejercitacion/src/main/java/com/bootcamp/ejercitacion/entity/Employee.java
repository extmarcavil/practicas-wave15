package com.bootcamp.ejercitacion.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "employee")
public class Employee {

    @Id
    private String id;
    private String  name;
    private String  lastname;
    private Integer age;
    private String  city;
    private String states;

}
