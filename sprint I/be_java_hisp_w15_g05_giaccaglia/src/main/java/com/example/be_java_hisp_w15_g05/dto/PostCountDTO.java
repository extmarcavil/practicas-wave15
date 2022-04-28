package com.example.be_java_hisp_w15_g05.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostCountDTO {
    private int userId;
    private String userName;
    private int promoProductsCount;
}
