package com.social.media.sprgbt.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductoDto {

    /**
     * Hace referencia a la clave primaria de la tabla Product
     */
    //@NotEmpty(message = "El campo no puede estar vacio")
    private Integer productId;

    /**
     * Hace referencia al nombre del Product
     */
    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 40, message = "Longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String productName;

    /**
     * Hace referencia al tipo del Product
     */
    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "Longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String type;

    /**
     * Hace referencia al marca del Product
     */
    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 25, message = "Longitud maxima 25 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String brand;

    /**
     * Hace referencia al color del Product
     */
    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "Longitud maxima 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String color;

    /**
     * Hace referencia al las anotaciones del Product
     */
    @Size(max = 80, message = "Longitud maxima 80 caracteres")
    private String notes;
}
