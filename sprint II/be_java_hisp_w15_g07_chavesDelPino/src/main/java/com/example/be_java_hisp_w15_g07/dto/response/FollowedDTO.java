package com.example.be_java_hisp_w15_g07.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FollowedDTO {
    private Integer userID;
    private String userName;
    private List<UserFollowersDTO> followed;
}