package com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserRequestDTO {

    private String username;
    private String password;


}
