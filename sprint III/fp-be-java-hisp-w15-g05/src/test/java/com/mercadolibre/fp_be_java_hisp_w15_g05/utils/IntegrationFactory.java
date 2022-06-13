package com.mercadolibre.fp_be_java_hisp_w15_g05.utils;

import com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request.UserRequestDTO;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.SessionServiceImpl;

public class IntegrationFactory {

    private SessionServiceImpl service;

    public IntegrationFactory(SessionServiceImpl service) {
        service = service;
    }

    public String getToken() {
        return service.login(new UserRequestDTO("usertest", "test")).getToken();
    }
}
