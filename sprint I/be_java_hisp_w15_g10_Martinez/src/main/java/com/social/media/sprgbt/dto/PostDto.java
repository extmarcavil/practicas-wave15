package com.social.media.sprgbt.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.social.media.sprgbt.entity.Product;
import com.social.media.sprgbt.entity.User;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDto implements Comparable<PostDto> {

    /**
     * Hace referencia a la primary Key de la publicacion.
     */
    @JsonIgnore
    private Integer postId;

    /**
     * Hace Referencia a la relacion entre el usuario y las publicaciones.
     */
    private Integer userId;

    /***
     * hace referenchia a la fecha de publicacion del producto .
     */
    private LocalDate date;

    /***
     * hace referenchia a un producto publicado.
     */
    @JsonProperty("detail")
    private ProductoDto productoDto;

    /**
     * Hace referencia a la categoria que corresponde la el producto ()
     */
    private Integer category;

    /**
     * Hace referencia a el precio del producto.
     */
    private Double price;

    /**
     * Hace referencia a si el producto esta en promocion
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean hasPromo;

    /**
     * Hace referencia al descuento que tiene el producto en promocion.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double discount;

    /**
     * CompareTo
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(PostDto o) {
        if (this.getDate() == null || o.getDate() == null) {
            return 0;
        }
        return this.getDate().compareTo(o.getDate());

    }
}
