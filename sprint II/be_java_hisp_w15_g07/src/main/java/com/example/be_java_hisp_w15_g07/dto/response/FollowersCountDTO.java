package com.example.be_java_hisp_w15_g07.dto.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FollowersCountDTO implements Serializable {
    private Integer userId;
    private String userName;
    private Integer followersCount;
}
