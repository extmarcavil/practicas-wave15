package com.sprint.be_java_hisp_w15_g10.DTO.Request;

import com.sprint.be_java_hisp_w15_g10.DTO.DTOEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryCreateDTO implements DTOEntity {
    @NotBlank
    private String category_name;
}
