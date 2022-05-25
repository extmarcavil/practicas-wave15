package com.practica.empleado.Producto.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "empleado")
public class Empleado {

    @Id
    private String id;

    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String departamenteo;
}
