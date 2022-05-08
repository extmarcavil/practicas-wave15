package com.social.media.sprgbt.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "El campo no puede estar vacio")
    private String nameCategory;
}
