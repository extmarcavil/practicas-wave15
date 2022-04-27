package com.sprint.be_java_hisp_w15_g10.DTO.Response;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VendedorsFollowedDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("followed")
    private List<UserDTO> followed;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserDTO> getFollowed() {
        return followed;
    }

    public void setFollowed(List<UserDTO> followed) {
        this.followed = followed;
    }
}
