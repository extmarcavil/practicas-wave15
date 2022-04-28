package com.sprint.be_java_hisp_w15_g10.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPromoPostResponseDTO {
    private int user_id;
    private List<PromoPostResponseDTO> posts;
}
