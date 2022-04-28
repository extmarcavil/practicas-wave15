package com.example.be_java_hisp_w15_g07.dto.response;

import com.example.be_java_hisp_w15_g07.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostDTO extends Post {
    private Boolean hasPromo;
    private Double discount;
}
