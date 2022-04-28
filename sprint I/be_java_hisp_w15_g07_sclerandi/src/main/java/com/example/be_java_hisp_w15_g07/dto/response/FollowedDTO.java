package com.example.be_java_hisp_w15_g07.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowedDTO {
    private Integer userID;
    private String userName;
    private List<UserFollowersDTO> followed;
}