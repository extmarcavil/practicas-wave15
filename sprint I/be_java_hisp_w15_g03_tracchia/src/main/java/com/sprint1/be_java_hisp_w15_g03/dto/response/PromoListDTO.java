package com.sprint1.be_java_hisp_w15_g03.dto.response;

import com.sprint1.be_java_hisp_w15_g03.dto.PersonDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.request.PublicationPromoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PromoListDTO extends PersonDTO {

    private List<PromoRespDTO> posts;

    public PromoListDTO(Integer userId, String userName, List<PromoRespDTO> posts) {
        super(userId, userName);
        this.posts = posts;
    }

}
