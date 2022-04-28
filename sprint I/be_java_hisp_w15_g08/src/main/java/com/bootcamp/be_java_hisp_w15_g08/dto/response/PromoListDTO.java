package com.bootcamp.be_java_hisp_w15_g08.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoListDTO {
    private Integer user_id;
    private String user_name;
    private List<PromoSellerListDTO> posts;
}
