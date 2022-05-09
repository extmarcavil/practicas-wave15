package com.be.java.hisp.w156.be.java.hisp.w156.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserCountFollowersDTO {

    private Integer user_id;
    private String user_name;
    private Integer followers_count;
}
