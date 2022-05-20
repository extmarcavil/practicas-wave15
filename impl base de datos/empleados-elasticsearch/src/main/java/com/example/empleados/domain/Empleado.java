package com.example.empleados.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "empleado")
@Getter
@Setter
public class Empleado {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Localidad localidad;
}
