package com.bootcamp.be_java_hisp_w15_g08.dto.response;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.PromoDTO;
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
    private int user_id;
    private String user_name;
    private List<PromoDTO> posts;
}
