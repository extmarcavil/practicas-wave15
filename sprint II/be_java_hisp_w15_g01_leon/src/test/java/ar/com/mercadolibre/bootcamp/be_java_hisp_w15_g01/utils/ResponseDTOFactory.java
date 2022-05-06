package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;

public class ResponseDTOFactory {
    public static ResponseDTO create(String msg) {
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage(msg);
        return dto;
    }
}
