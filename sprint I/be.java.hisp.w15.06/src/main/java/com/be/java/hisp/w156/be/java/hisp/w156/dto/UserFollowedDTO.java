package com.be.java.hisp.w156.be.java.hisp.w156.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UserFollowedDTO {

    private Integer user_id;
    private String user_name;
    private List<UserDTO> followed;

}
