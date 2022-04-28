package com.example.be_java_hisp_w15_g05.dto.response;


import com.example.be_java_hisp_w15_g05.dto.PromoPostIdDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResListPromoPostDTO {
    private int userId;
    private String userName;
    private List<PromoPostIdDTO> posts;

}
