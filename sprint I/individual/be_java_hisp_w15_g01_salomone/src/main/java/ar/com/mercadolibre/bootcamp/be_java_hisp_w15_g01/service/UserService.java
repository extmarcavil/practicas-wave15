package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowedListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.CountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

public interface UserService {
    ResponseDTO follow(Long userId, long userIdToFollow);
    User findById(Long id);

    FollowersListDTO whoFollowsMe(Long id, String order);
    CountDTO wowManyFollowsMe(Long userId);

    FollowedListDTO findAllFollowedByUserId(Long userId, String order);

    ResponseDTO unFollow(Long userId, long userIdToUnfollow);

}
