package com.sprint1.be_java_hisp_w15_g4.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint1.be_java_hisp_w15_g4.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostDTO {
    private int user_id;
    private int post_id;
    @JsonFormat(pattern = "dd-MM-yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private ProductDTO detail;
    private int category;
    private double price;
}
