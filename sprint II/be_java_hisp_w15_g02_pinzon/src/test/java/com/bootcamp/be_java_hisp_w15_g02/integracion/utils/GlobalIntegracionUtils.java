package com.bootcamp.be_java_hisp_w15_g02.integracion.utils;


import com.bootcamp.be_java_hisp_w15_g02.dto.response.GetFollowersDTO;

import java.util.List;

public class GlobalIntegracionUtils {


    public static List<GetFollowersDTO> listFollowedUser() throws Exception{
        var follow1 = new GetFollowersDTO();
        follow1.setUserId(1);
        follow1.setUserName("Martin");
        var follow2 = new GetFollowersDTO();
        follow2.setUserId(2);
        follow2.setUserName("Diana");
        var follow3 = new GetFollowersDTO();
        follow3.setUserId(3);
        follow3.setUserName("Leo");
        List<GetFollowersDTO> listResult = List.of(follow1,follow2,follow3);
        return listResult;
    }
}
