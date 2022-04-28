package com.sprint1.be_java_hisp_w15_g03.dto.response;

import com.sprint1.be_java_hisp_w15_g03.dto.PersonDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationPromoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * US: 12
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerPPromoListDTO extends PersonDTO {

    private List<PublicationPromoComDTO> posts;
}
