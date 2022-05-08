package com.social.media.sprgbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.*;
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
    //@NotBlank(message = "Atributo no puede ser Null o Vacio")
    private Integer userId;

    /***
     * hace referenchia a la fecha de publicacion del producto .
     */
    @NotNull(message = "El campo no puede estar vacio")
    @JsonFormat(pattern = "dd-MM-yyyy")
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
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
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
     * @return int
     */
    @Override
    public int compareTo(PostDto o) {
        if (this.getDate() == null || o.getDate() == null) {
            return 0;
        }
        return this.getDate().compareTo(o.getDate());

    }
}
