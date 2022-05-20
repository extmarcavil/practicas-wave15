package com.bootcamp.elastic.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;


@Getter
@Setter
public class LiteratureDTO {
    private String id;
    private String title;
    private String author;
    private Integer cantPages;
    private String editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate firstPost;
}
