package com.example.be_java_hisp_w15_g07.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class FollowersCountDTO implements Serializable {
    private Integer userId;
    private String userName;
    private Integer followersCount;
}
