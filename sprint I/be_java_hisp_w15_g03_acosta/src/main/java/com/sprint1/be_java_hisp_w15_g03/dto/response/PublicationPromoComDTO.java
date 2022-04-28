package com.sprint1.be_java_hisp_w15_g03.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * para "posts:" de US:12
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationPromoComDTO extends PublicationRespDTO {

    private Boolean hasPromo;
    private Double discount;

}
