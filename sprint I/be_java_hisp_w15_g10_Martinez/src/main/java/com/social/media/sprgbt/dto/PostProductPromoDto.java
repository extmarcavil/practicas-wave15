package com.social.media.sprgbt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PostProductPromoDto {

    private Integer userId;

    private String userName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer promoProductsCount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<PostDto> postList;
}
