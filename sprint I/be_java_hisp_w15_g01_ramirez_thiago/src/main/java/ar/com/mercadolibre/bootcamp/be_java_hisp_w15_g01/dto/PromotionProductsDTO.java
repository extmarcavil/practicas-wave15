package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionProductsDTO extends PostDTO{

    private boolean hasPromo;
    private double discount;

}
