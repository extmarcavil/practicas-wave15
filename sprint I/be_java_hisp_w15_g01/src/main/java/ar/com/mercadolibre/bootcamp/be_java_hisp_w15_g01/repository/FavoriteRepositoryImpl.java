package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Favorite;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository {
    private final List<Favorite> favorites;

    public FavoriteRepositoryImpl() {
        this.favorites = new ArrayList<>();
    }

    @Override
    public Favorite save(User user, Post post) {
        /*if(this.existFavorite(user, post)){
            throw new AlreadyFollowerExcepcion();
        } */
        Favorite favorite = new Favorite(user, post);
        favorites.add(favorite);
        return favorite;
    }

    @Override
    public Boolean existFavorite(User user, Post post) {
        return favorites.stream().anyMatch(f -> f.getUser().equals(user) && f.getPost().equals(post));
    }


    @Override
    public List<Favorite> whoFavorite(User user) {
        return favorites
                .stream()
                .filter(f -> f.getUser().equals(user))
                .collect(Collectors.toList());
    }

}
