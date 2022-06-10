package com.mercadolibre.fp_be_java_hisp_w15_g06.service.securitySession;

import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.requestDTO.UserRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g06.dtos.responseDTO.UserResponseDTO;

public interface IServiceSession {
    UserResponseDTO login(UserRequestDTO userRequestDTO);
    String getUsername(String token);
}
