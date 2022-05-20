package com.elastic.crud.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Document(indexName = "employee")
public class Employee {


    @Id
    private String id;
    private String name;
    private String lastname;
    private Integer age;
    private String city;

    /*@Field(type = FieldType.Date)
    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDate date;
*/
}

