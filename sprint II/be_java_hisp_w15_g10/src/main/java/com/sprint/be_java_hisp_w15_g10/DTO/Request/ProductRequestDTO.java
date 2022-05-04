package com.sprint.be_java_hisp_w15_g10.DTO.Request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ProductRequestDTO {


    @NotNull(message = "La id no puede estar vacía")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Integer product_id;


    @NotBlank(message = "El campo no puede estar vacío")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String product_name;


    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @NotBlank(message = "El campo no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String type;


    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres")
    @NotBlank(message = "El campo no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String brand;


    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @NotBlank(message = "El campo no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String color;


    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9-ñ ]*$", message = "El campo no puede poseer caracteres especiales")
    @JsonProperty
    private String notes;
}
