package com.sprint1.be_java_hisp_w15_g4.dto.response;

import com.sprint1.be_java_hisp_w15_g4.dto.request.PromoPostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PromoListDTO {
    private int user_id;
    private String user_name;
    private List<PromoPostDTO> posts;
}
