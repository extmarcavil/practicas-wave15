package com.social.media.sprgbt.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDto {

    /**
     * Hace referencia a la llave primaria de categoria
     */
    private Integer categoryId;
    /**
     * Hace referencia al nombre de la categoria
     */
    private String nameCategory;
}
