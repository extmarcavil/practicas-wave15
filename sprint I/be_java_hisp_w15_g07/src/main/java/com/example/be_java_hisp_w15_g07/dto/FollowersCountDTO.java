package com.example.be_java_hisp_w15_g07.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FollowersCountDTO implements Serializable {
    Integer count;
}
