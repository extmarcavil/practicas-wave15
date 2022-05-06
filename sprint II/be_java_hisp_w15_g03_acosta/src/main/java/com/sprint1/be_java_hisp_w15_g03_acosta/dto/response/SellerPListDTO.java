package com.sprint1.be_java_hisp_w15_g03_acosta.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * US:06
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerPListDTO {

    private Integer userId;
    private List<PublicationRespDTO> posts;
}
