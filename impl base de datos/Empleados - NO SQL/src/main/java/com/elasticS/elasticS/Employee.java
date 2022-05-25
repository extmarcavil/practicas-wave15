package com.elasticS.elasticS;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Document(indexName = "employee") //es lo mismo que el @entity en sql
public class Employee {
    @Id
    private String id; //el id es un string pq elastic crea el id con nuros y letras y no hay un identificador en java mas q string
    private String name;
    private String lastname;
    private Integer age;
    private String city;

    @Field(type = FieldType.Date) //Esto lo agrego pq sino la fecha la guarda como un numero en lugar de como un numero. equivale a @Column en jpa
    @JsonFormat(pattern =  "dd/MM/yyyy") // esto lo agrego para cuando me lo traiga de la bd o cuando cree un elemento que haga la conversion del tipo q almacena elastic a java
    private LocalDate date;
}
