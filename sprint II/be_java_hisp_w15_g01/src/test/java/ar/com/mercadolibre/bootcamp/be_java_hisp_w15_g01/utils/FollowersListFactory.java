package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Follow;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

import java.util.Arrays;
import java.util.List;

public class FollowersListFactory {

    public static List<Follow> createLista(){
        User u1 = UserFactory.createLuky();
        User u2 = UserFactory.createJesu();
        return Arrays.asList(FollowFactory.create(u2,u1));
    }

}
