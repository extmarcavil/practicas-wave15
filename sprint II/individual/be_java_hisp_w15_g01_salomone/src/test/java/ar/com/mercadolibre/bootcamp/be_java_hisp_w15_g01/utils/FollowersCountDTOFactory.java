package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

public class FollowersCountDTOFactory {

    public static FollowersCountDTO count(){
        User u1 = UserFactory.createJesu();
        FollowersCountDTO f = new FollowersCountDTO();
        f.setUserId(u1.getUserId());
        f.setUserName(u1.getUserName());
        f.setFollowersCount(0);
        return  f;
    }
}


