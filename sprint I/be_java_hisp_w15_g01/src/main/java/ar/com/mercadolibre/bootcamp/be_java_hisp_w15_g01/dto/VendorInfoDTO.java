package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long promoProductsCount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long totalCount;
}
