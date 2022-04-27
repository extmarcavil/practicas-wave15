package com.sprint1.be_java_hisp_w15_g03.dto.response;

import com.sprint1.be_java_hisp_w15_g03.dto.PersonDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.PublicationWithPromoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * US:12
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationPListDTO extends PersonDTO {
    private List<PublicationRespWithPromoDTO> posts;
}
