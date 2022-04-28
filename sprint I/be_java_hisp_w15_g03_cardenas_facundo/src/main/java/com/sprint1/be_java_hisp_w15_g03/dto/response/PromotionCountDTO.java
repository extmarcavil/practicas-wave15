package com.sprint1.be_java_hisp_w15_g03.dto.response;

import com.sprint1.be_java_hisp_w15_g03.dto.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
   US 11  Autor @Facundo Cardenas
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionCountDTO extends PersonDTO {

    private Integer promo_products_count;
}
