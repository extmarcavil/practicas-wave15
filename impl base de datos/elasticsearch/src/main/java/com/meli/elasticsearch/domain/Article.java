package com.meli.elasticsearch.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "articleindex")
@Getter @Setter
public class Article implements ElasticDocument {

    public static final String INDEX = "articleindex";

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;

}
