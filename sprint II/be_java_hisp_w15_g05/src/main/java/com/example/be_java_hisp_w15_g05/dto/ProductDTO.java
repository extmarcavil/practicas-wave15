package com.example.be_java_hisp_w15_g05.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @Min(value = 1, message = "El ID del post no puede ser menor a 0")
    @NotNull(message = "El ID del post no puede estar vacio")
    private int productId;
    @Size(min = 1, max = 40, message = "El nombre debe contener hasta 40 caracteres")
    @NotNull(message = "El nombre del producto no puede estar vacio")
    @Pattern(regexp = "^[a-zA-Z0-9– ]*$", message = "El nombre no debe contener caracteres especiales")
    private String productName;
    @NotNull(message = "El tipo de producto no puede estar vacio")
    @Size(min = 1, max = 15, message = "El tipo de producto debe contener hasta 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "El tipo de producto no debe contener caracteres especiales")
    private String type;
    @NotNull(message = "La marca no debe estar vacia")
    @Size(min = 1, max = 25, message = "La marca de producto debe contener hasta 25 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "La marca de producto no debe contener caracteres especiales")
    private String brand;
    @NotNull(message = "El producto debe tener un color")
    @Size(min = 1, max = 15, message = "El color debe contener hasta 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "El color de producto no debe contener caracteres especiales")
    private String color;
    @NotNull(message = "Las notas no deben estar vacia")
    @Size(min = 1, max = 80, message = "Las notas de producto debe contener hasta 80 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9- ]*$", message = "Las notas de producto no debe contener caracteres especiales")
    private String notes;
}
