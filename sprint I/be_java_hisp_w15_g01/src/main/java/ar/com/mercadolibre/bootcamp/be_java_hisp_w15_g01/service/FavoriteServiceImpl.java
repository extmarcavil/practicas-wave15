package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import org.springframework.stereotype.Service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.FavoriteDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FavoriteRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final UserService userService;
    private final PostRepository postRepository;
    private final FavoriteRepository favoriteRepository;

    FavoriteServiceImpl(UserService userService, PostRepository postRepository, FavoriteRepository favoriteRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public ResponseDTO create(FavoriteDTO favoriteDTO) {
        User user = userService.findById(favoriteDTO.getUserId());
        Post post = this.postRepository.findById(favoriteDTO.getProductId());
        favoriteRepository.save(user, post);
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Favorite Created!");
        return dto;
    }
}
