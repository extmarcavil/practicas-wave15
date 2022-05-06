package com.social.media.sprgbt.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    /**
     * Hace referencia a la clave primaria de la tabla Product
     */
    private Integer productId;

    /**
     * Hace referencia al nombre del Product
     */
    private String productName;

    /**
     * Hace referencia al tipo del Product
     */
    private String type;

    /**
     * Hace referencia al marca del Product
     */
    private String brand;

    /**
     * Hace referencia al color del Product
     */
    private String color;

    /**
     * Hace referencia al las anotaciones del Product
     */
    private String notes;


}
