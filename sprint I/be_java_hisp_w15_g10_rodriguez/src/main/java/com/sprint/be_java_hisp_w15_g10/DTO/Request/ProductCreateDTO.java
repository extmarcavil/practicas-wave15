package com.sprint.be_java_hisp_w15_g10.DTO.Request;

import com.sprint.be_java_hisp_w15_g10.DTO.DTOEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDTO implements DTOEntity {
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

    @Override
    public String toString() {
        return product_name + type + brand + color + notes;
    }
}
