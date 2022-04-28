package com.sprint1.be_java_hisp_w15_g03.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
* US010
* */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationPromoDTO extends PublicationDTO{
       Boolean hasPromo;
       Double discount;

}
