package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.PostListDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ProductDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.ResponseDTO;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidDateException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final UserService userService;
    private final PostRepository postRepository;
    private final FollowRepository followRepository;

    PostServiceImpl(UserService userService, PostRepository postRepository, FollowRepository followRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
        this.followRepository = followRepository;
    }

    @Override
    public ResponseDTO createPost(PostDTO postDto) {
        User user = userService.findById(postDto.getUserId());
        ProductDTO detail = postDto.getDetail();

        Product product = new Product(
                detail.getProductId(),
                detail.getProductName(),
                detail.getType(),
                detail.getBrand(),
                detail.getColor(),
                detail.getNotes()
        );

        LocalDate date;

        try {
            date = LocalDate.parse(postDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch(DateTimeException e) {
            throw new InvalidDateException();
        }

        Post createdPost = postRepository.create(user, date, product, postDto.getCategory(), postDto.getPrice());

        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Product Created!");

        return dto;
    }

    @Override
    public PostListDTO getPostsByFollowedUsers(Long userId) {
        List<User> followedUsers = followRepository.findFollowedByUserId(userId);

        PostListDTO postListDTO = new PostListDTO(userId, null);
        List<PostDTO> internalPostList = new ArrayList<>();

        for(User v : followedUsers) {
            this.postRepository.getAllPostsByUserWithinTimespan(v, 14)
                    .forEach(p -> internalPostList.add(new PostDTO(p)));
        }

        List<PostDTO> sortedAscPostList = internalPostList.stream()
                .sorted(Comparator.comparing(PostDTO::getDate))
                .collect(Collectors.toList());

        Collections.reverse(sortedAscPostList);

        postListDTO.setPosts(sortedAscPostList);

        return postListDTO;
    }
}
