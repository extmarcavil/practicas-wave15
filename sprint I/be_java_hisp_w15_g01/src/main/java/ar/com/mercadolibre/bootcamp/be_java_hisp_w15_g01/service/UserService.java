package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.UserDto;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;

public interface UserService {
    ResponseDTO follow(Long userId, long userIdToFollow);
    User findById(Long id);
    UserDto findAllFollowersById(Long userId);
}
