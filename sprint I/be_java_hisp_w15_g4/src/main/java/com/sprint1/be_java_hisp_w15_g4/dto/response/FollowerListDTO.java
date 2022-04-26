package com.sprint1.be_java_hisp_w15_g4.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint1.be_java_hisp_w15_g4.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class FollowerListDTO {
    private int user_id;
    private String user_name;
    @JsonProperty("followers")
    private List<UserDTO> followerList;
}
