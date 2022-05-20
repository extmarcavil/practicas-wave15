package com.bootcamp.elastic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiteratureDto {
    private String id;
    private String title;
    private String author;
    private Integer cantPages;
    private String editorial;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private String firstPost;
}
