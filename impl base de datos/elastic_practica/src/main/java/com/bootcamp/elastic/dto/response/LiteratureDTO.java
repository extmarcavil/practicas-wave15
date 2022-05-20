package com.bootcamp.elastic.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiteratureDTO {
    private String    title;
    private String    author;
    private Integer   cantPages;
    private String    editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate firstPost;
}
