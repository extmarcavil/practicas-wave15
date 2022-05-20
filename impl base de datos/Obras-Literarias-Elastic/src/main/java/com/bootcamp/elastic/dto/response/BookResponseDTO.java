package com.bootcamp.elastic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {

    private String    id;
    private String    title;
    private String    author;
    private Integer   cantPages;
    private String    editorial;
    private LocalDate firstPost;
}
