package com.bootcamp.elastic.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "autor")
public class Autor {

    @Id
    private String id;
    private String nombre;
}
