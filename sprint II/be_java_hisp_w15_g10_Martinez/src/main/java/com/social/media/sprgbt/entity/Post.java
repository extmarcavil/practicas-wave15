package com.social.media.sprgbt.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

    /**
     * Hace referencia a la primary Key de la publicacion.
     */
    private Integer postId;

    /**
     * Hace Referencia a la relacion entre el usuario y las publicaciones.
     */
    private Integer userId;

    /***
     * hace referenchia a un producto publicado.
     */
    private Integer productId;

    /**
     * Hace referencia a la categoria que corresponde la el producto ()
     */
    private Integer categoryId;

    /***
     * hace referenchia a la fecha de publicacion del producto .
     */
    private LocalDate date;

    /**
     * Hace referencia a el precio del producto.
     */
    private Double price;

    /**
     * Hace referencia a si el producto esta en promocion
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean hasPromo = false;

    /**
     * Hace referencia al descuento que tiene el producto en promocion.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double discount;

}
