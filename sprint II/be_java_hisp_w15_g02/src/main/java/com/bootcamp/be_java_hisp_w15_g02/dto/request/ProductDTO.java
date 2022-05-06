package com.bootcamp.be_java_hisp_w15_g02.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class ProductDTO {
    @NotNull(message = "La id no puede estar vacia")
    @Min(1)
    private Integer product_id;
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(message = "La longitud no puede superar los 40 caracteres.", max = 40)
    @Pattern(message = "El campo no puede poseer caracteres especiales.", regexp = "^\\w+( +\\w+)*$")
    private String product_name;
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(message = "La longitud no puede superar los 15 caracteres.", max = 15)
    @Pattern(message = "El campo no puede poseer caracteres especiales.", regexp = "^\\w+( +\\w+)*$")
    private String type;
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(message = "La longitud no puede superar los 25 caracteres.", max = 25)
    @Pattern(message = "El campo no puede poseer caracteres especiales.", regexp = "^\\w+( +\\w+)*$")
    private String brand;
    @NotBlank(message = "El campo no puede estar vacio")
    @Size(message = "La longitud no puede superar los 15 caracteres.", max = 15)
    @Pattern(message = "El campo no puede poseer caracteres especiales.", regexp = "^\\w+( +\\w+)*$")
    private String color;
    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(message = "La longitud no puede superar los 80 caracteres.", max = 80)
    @Pattern(message = "El campo no puede poseer caracteres especiales.", regexp = "^\\w+( +\\w+)*$")
    private String notes;


    public ProductDTO() {
    }

    public ProductDTO(int product_id, String product_name, String type, String brand, String color, String notes) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }
}
