package com.bootcamp.elastic.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
public class LiteratureDto {

    @Id
    private String    id;
    private String    title;
    private String    author;
    private Integer   cantPages;
    private String    editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Field(type = FieldType.Date)
    private LocalDate firstPost;
}
