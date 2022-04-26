package com.sprint1.be_java_hisp_w15_g03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {

    private Integer postId;
    private LocalDate date;
    private Category category;
    private Double price;
    private Product detail;
    private Boolean hasPromo;
    private Double discount;
}
