package com.meli.elasticsearch.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Document(indexName = "literarywork")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class LiteraryWork implements ElasticDocument {

    public static final String INDEX = "literarywork";

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @JsonProperty("number_of_pages")
    @Field(name = "number_of_pages", type = FieldType.Integer)
    private int numberOfPages;

    @Field(type = FieldType.Text)
    private String author;

    @Field(type = FieldType.Text)
    private String editorial;

    @JsonProperty("year_of_publication")
    @Field(name = "year_of_publication", type = FieldType.Date)
    private LocalDate yearOfPublication;

}
