package com.practica.empleado.Producto.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "producto")
public class Producto {

    @Id
    private String id;

    private String nombre;
    private String tipo;// (comestible, limpieza, etc),
    private Double precioVenta;
    private Double precioCosto;
    private Integer cantidadDisponible;

}
