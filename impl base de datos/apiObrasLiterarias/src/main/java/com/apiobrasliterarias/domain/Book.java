package com.apiobrasliterarias.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "booksdb")
public class Book {
    private String id;
    private String title;
    private String author;
    @Field(type = FieldType.Integer,name = "cant_pages")
    private int pages;
    private String editorial;
    @Field(type = FieldType.Date,name = "first_post")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate post;
}
