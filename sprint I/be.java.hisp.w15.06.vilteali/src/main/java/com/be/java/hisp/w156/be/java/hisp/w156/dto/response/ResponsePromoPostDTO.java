package com.be.java.hisp.w156.be.java.hisp.w156.dto.response;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.ResponsePostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder({ "id", "username", "posts" })
public class ResponsePromoPostDTO {

    @JsonProperty("user_id")
    private final Integer id;

    @JsonProperty("user_name")
    private final String username;

    private final List<ResponsePostDTO> posts;

    public static ResponsePromoPostDTO from(User user, List<ResponsePostDTO> posts) {
        return new ResponsePromoPostDTO(user.getId(), user.getName(), posts);
    }
}
