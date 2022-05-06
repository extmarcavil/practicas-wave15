package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ErrorDTO {
    private Boolean success = false;
    private Map<String, String> errors;
}
