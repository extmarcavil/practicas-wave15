package com.example.blog.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntryRequestDTO implements Serializable {
    private int id;
    private String title;
    private String author;

    @JsonFormat(pattern="dd/MM/yyyy", shape=JsonFormat.Shape.STRING)
    private LocalDate publicationDate;
}
