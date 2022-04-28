package com.sprint1.be_java_hisp_w15_g03.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDiscountDTO {

    private Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private ProductDTO detail;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
