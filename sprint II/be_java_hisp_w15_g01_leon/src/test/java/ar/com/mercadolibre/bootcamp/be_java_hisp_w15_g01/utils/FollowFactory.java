package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Follow;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

public class FollowFactory {
    public static Follow create(User u1, User u2) {
        Follow f = new Follow();
        f.setFollower(u1);
        f.setFollowing(u2);
        return f;
    }
}
