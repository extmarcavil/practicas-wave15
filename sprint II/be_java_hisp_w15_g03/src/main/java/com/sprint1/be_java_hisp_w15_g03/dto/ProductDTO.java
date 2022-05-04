package com.sprint1.be_java_hisp_w15_g03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotNull(message = "El  id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero.")
    private Integer productId;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    private String productName;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    //[\sa-zA-Z0-9ñáéíóúÁÉÍÓÚÜü]* opcion dos
    @Pattern(regexp = "[\\s|0-9A-Za-zñóíáéúÁÓÉÍÚ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "[\\s|0-9A-Za-zñóíáéúÁÓÉÍÚ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[\\s|0-9A-Za-zñóíáéúÁÓÉÍÚ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "[\\s|0-9A-Za-zñóíáéúÁÓÉÍÚ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String notes;

}
