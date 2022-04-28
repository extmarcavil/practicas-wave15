package com.bootcamp.be_java_hisp_w15_g08.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewPromoDTO {
    private int postID;
    private Integer user_id;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private DetailDTO detail;
    private Integer category;
    private double price;
    private boolean has_promo;
    private double discount;

}
