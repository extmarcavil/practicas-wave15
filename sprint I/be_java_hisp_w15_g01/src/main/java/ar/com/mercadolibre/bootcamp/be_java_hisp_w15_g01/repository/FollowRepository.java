package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Follow;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

import java.util.List;

public interface FollowRepository {
    Follow save(User follower, User following);
    List<User> findByUserFollowedId(Long id);
}
