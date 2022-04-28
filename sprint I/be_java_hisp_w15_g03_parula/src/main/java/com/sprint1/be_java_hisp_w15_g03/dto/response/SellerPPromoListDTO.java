package com.sprint1.be_java_hisp_w15_g03.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerPPromoListDTO{
    private Integer userId;
    private String userName;
    private List<PublicationPromoRespDTO> posts;
}
