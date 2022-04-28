package com.example.be_java_hisp_w15_g07_ravelli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPromoPosts {
    public Integer userID;
    public String userName;
    public List<PromoPostDTO> posts;
}
