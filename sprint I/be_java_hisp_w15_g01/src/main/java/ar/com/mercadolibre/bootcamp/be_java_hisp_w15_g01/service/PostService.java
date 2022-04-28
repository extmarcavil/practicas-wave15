package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import java.util.List;

public interface PostService {

    ResponseDTO createPost(PostDTO postDto);

    PostListDTO getPostsByFollowedUsers(Long userId, String order);

    VendorInfoDTO getPostCount(Long userId, Boolean hasPromo, Integer daysInterval);

    PostListDTO getPromoPostsByUser(Long userId);

    List<VendorInfoDTO> getPosterRanking(Integer daysInterval);
}
