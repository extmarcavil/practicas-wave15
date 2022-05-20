package com.ejercicio.ElasticSearchEmployees.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//GET /employee/_search # nodo 1
// GET /employee/_search # nodo 2
@Data
@Document(indexName = "employee") // @Entity en JPA
public class Employee {

    @Id
    private String  id;
    private String  name;
    private String  lastname;
    private Integer age;
    private String  city;

/*    @Field(type = FieldType.Date) // @Column en JPA
    @JsonFormat(pattern = "dd/MM/yyyy") // para ambos casos
    private LocalDate date;*/
}