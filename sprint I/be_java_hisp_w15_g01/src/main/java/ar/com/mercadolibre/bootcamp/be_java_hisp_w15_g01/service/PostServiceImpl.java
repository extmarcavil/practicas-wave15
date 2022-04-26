package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class PostServiceImpl implements PostService {

    private final UserService userService;
    private final PostRepository postRepository;

    PostServiceImpl(UserService userService, PostRepository postRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
    }

    @Override
    public ResponseDTO createPost(PostDTO postDto) {
        User user = userService.findById(postDto.getUserId());
        postRepository.create(user, LocalDate.now(), postDto.getDetail(), postDto.getCategory(), postDto.getPrice());
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Product Created!");
        return dto;
    }
}
