package com.bootcamp.elastic.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Builder
public class LiteratureDto {
    private String    title;
    private String    author;
    private Integer   cantPages;
    private String    editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate firstPost;
}
