package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserResponseDTO {

    private String name;
    private String token;
}
