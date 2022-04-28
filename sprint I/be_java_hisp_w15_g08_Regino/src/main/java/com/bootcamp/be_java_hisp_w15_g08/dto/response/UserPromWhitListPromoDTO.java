package com.bootcamp.be_java_hisp_w15_g08.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPromWhitListPromoDTO {
    //No herede de user DTO por la forma en que definimos los nombres ahi. luego revisar y cambiar los nombres.
    private Integer user_id;
    private String user_name;
    private List<PostNotUserIdDTO> posts;
}
