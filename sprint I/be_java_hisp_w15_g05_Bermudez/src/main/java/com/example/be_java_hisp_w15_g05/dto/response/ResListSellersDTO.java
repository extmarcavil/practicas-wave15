package com.example.be_java_hisp_w15_g05.dto.response;

import com.example.be_java_hisp_w15_g05.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResListSellersDTO {
    private int userId;
    private String userName;
    private List<UserDTO> followed;

    public ResListSellersDTO(int userId, String userName, List<UserDTO> followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed= followed;
    }
}
