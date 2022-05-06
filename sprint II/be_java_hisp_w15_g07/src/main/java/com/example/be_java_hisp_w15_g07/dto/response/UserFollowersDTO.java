package com.example.be_java_hisp_w15_g07.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserFollowersDTO {
    private Integer userID;
    private String userName;
}
