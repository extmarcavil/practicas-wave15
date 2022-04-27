package com.sprint.be_java_hisp_w15_g10.DTO.Request;


import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ProductRequestDTO {
    @Min(1)
    private int product_id;
    @NotBlank
    private String product_name;
    @NotBlank
    private String type;
    @NotBlank
    private String brand;
    @NotBlank
    private String color;
    @NotBlank
    private String notes;
}
