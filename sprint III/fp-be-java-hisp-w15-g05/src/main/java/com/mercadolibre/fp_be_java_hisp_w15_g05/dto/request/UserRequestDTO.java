package com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String user_name;
    private String password;
}
