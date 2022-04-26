package com.bootcamp.be_java_hisp_w15_g02.dto.response;

import com.bootcamp.be_java_hisp_w15_g02.dto.request.GetFollowersDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetFollowersBySeller {
    private int user_id;
    private String user_name;
    private List<GetFollowersDTO> followers;

    public GetFollowersBySeller() {
    }
}
