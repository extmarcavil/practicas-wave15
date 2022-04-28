package com.example.be_java_hisp_w15_g07.dto.request;

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
public class NewPromoPostDTO extends NewPostDTO{

    private Boolean hasPromo;
    private Double discount;
}
