package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Favorite;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import java.util.List;

public interface FavoriteRepository {
    Favorite save(User user, Post post);
    Boolean existFavorite(User user, Post post);
    List<Favorite> whoFavorite(User user);
}
