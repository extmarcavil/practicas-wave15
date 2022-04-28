package com.be.java.hisp.w156.be.java.hisp.w156.dto.response;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.PromoPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListPromoPostDTO {
    private int     user_id;
    private String  user_name;
    List<PromoPostDTO> promoPostList;

}
