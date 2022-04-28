package com.example.be_java_hisp_w15_g05.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResListPromoPostDTO {
    private PostDTO post;
    private boolean hasPromo;
    private double discount;
}
