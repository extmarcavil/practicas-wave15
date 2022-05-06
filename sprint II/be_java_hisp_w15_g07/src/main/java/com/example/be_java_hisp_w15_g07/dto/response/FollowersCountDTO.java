package com.example.be_java_hisp_w15_g07.dto.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
