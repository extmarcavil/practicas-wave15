package com.example.be_java_hisp_w15_g07.dto.request;

import com.example.be_java_hisp_w15_g07.model.Product;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class NewPostDTO {

    private Integer userId;
    @JsonFormat (pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private Integer category;
    private Double price;


}
