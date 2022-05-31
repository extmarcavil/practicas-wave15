package com.spring.ejerciciocarritocomprasvivo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CartDTO {
    private Long id;
    private Set<ItemDTO> items;
}
