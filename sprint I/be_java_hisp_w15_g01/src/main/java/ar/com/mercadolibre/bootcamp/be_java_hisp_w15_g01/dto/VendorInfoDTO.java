package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class VendorInfoDTO {
    private Long userId;
    private String userName;
    private Long promoProductsCount;
}
