package com.example.be_java_hisp_w15_g07.dto.request;

import com.example.be_java_hisp_w15_g07.utils.RegexPattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductDTO {

    @NotNull(message = "El id no puede estar vacio")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer productId;

    @NotBlank(message = "El campo no puede estar vacio")
    @Length(max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = RegexPattern.PATTERN_WITH_SPACE, message = "El campo no puede poseer caracteres especiales")
    private String productName;

    @NotBlank(message = "El campo no puede estar vacio")
    @Pattern(regexp = RegexPattern.PATTERN, message = "El campo no puede poseer caracteres especiales")
    @Length(max = 15, message = "La longitud no puede superar los 15 caracteres")
    private String type;

    @NotBlank(message = "El campo no puede estar vacio")
    @Pattern(regexp = RegexPattern.PATTERN, message = "El campo no puede poseer caracteres especiales")
    @Length(max = 25, message = "La longitud no puede superar los 25 caracteres")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacio")
    @Pattern(regexp = RegexPattern.PATTERN, message = "El campo no puede poseer caracteres especiales")
    @Length(max = 15, message = "La longitud no puede superar los 15 caracteres")
    private String color;

    @Pattern(regexp = RegexPattern.PATTERN_WITH_SPACE, message = "El campo no puede poseer caracteres especiales")
    @Length(max = 80, message = "La longitud no puede superar los 80 caracteres")
    private String notes;
}

