package com.apiempleados.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "empladosdb")
public class Empleado {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private int edad;

    @Field(type = FieldType.Nested,includeInParent = true)
    private Direccion direccion;
}
