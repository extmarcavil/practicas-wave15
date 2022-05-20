package com.example.elastic.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Document(indexName = "employee")
public class Employee {

    @Id
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String city;

    @Field(type = FieldType.Date)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

}
