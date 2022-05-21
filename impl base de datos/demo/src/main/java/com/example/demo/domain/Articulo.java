package com.example.demo.domain;
import org.springframework.data.annotation.Id;


@Document(IndexName="blog")
public class Articulo {

    @Id
    private Long id;

    private String titulo;
    @Field(type= FieldType.Nested, IncludeInParent = true)
    private List<Autor> autors;
}
