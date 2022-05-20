package com.bootcamp.elastic.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
public class LiteratureDTO {
    private String    id;
    private String    title;
    private String    author;
    private Integer   cantPages;
    private String    editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate firstPost;
}
