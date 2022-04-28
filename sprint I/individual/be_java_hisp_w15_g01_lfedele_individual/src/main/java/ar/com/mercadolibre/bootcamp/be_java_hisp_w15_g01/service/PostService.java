package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;

public interface PostService {

    ResponseDTO createPost(PostDTO postDto);

    PostListDTO getPostsByFollowedUsers(Long userId, String order);

    ResponseDTO createPostPromo(PostPromoDTO dto);

    PromoProductCountDTO getUserPromoPosts(Long id);
}
