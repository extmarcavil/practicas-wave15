package com.be.java.hisp.w156.be.java.hisp.w156.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {

    @NotNull(message = "El id no puede estar vacía.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    private Integer product_id;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z \\\\s]+$",message = "El campo no puede poseer caracteres especiales.")
    private String product_name;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z \\\\s]+$",message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z \\\\s]+$",message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z \\\\s]+$",message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z \\\\s]+$",message = "El campo no puede poseer caracteres especiales.")
    private String notes;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}