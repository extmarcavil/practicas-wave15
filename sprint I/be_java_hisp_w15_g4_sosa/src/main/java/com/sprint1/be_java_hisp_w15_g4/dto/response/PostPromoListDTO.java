package com.sprint1.be_java_hisp_w15_g4.dto.response;

import com.sprint1.be_java_hisp_w15_g4.dto.request.PostPromoDTO;
import com.sprint1.be_java_hisp_w15_g4.model.PostPromo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostPromoListDTO {
    private int user_id;
    private String user_name;
    private List<PostPromoDTO> promos;

    public PostPromoListDTO(List<PostPromoDTO> promos) {
        this.promos = promos;
    }
}
