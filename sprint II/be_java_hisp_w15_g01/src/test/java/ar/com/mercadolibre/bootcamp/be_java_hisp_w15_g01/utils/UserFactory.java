package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.utils;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

public class UserFactory {
    public static User createLuky() {
        return new User(1L, "Lukf");
    }

    public static User createJesu() {
        return new User(2L, "JLeon");
    }

    public static User createGonza() {
        return new User(3L, "GSinnott");
    }

    public static User createAna() {
        return new User(4L, "AnaS");
    }

    public static User createThiago() {
        return new User(5L, "TRamirez");
    }

    public static User createMigue() {
        return new User(6L, "MBarraza");
    }
}
