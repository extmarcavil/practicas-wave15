package com.mercadolibre.fp_be_java_hisp_w15_g05.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusDTO {

    @NotEmpty(message = "El codigo del estado de la orden no debe estar vacio.")
    private String status_code;
}
