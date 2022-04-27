package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowedListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersCountDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FollowersListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseDTO follow(Long userId, long userIdToFollow);
    User findById(Long id);

    FollowersListDTO whoFollowsMe(Long id);
    FollowersCountDTO wowManyFollowsMe(Long userId);

    FollowedListDTO findAllFollowedByUserId(Long userId);

    ResponseDTO unFollow(Long userId, long userIdToUnfollow);

}
