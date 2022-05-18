package com.bootcamp.jewelry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResJewlDTO {
    private Long identification_num;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    private boolean owns_stone;
    private boolean available;
}
