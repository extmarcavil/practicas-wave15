package com.be.java.hisp.w156.be.java.hisp.w156.dto.response;

import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResponseCountPromoPostDTO {

    @JsonProperty("user_id")
    private final Integer id;

    @JsonProperty("user_name")
    private final String username;

    @JsonProperty("promo_products_count")
    private final long quantity;

    public static ResponseCountPromoPostDTO from(User user, long quantity) {
        return new ResponseCountPromoPostDTO(user.getId(), user.getName(), quantity);
    }
}
