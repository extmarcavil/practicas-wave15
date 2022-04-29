package com.sprint.be_java_hisp_w15_g10.DTO.Request;


import com.sprint.be_java_hisp_w15_g10.DTO.DTOEntity;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRequestDTO implements DTOEntity {
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
