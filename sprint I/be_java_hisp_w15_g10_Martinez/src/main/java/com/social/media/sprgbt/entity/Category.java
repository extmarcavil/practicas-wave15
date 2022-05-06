package com.social.media.sprgbt.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {

    /**
     * Hace referencia a la llave primaria de categoria
     */
    private Integer categoryId;
    /**
     * Hace referencia al nombre de la categoria
     */
    private String nameCategory;

}
