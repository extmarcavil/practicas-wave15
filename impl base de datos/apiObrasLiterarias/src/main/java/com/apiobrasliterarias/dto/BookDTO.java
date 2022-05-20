package com.apiobrasliterarias.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String title;
    private String author;
    private int pages;
    private String editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate post;
}
