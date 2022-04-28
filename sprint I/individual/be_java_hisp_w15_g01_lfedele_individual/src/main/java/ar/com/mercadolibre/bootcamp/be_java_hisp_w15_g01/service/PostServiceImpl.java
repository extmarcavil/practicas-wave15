package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidArgumentException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidDateException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
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
@Log
public class PostServiceImpl implements PostService {

    private final UserService userService;
    private final PostRepository postRepository;
    private final FollowRepository followRepository;
    private final ModelMapper mapper;

    PostServiceImpl(UserService userService, PostRepository postRepository, FollowRepository followRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
        this.followRepository = followRepository;
        this.mapper = new ModelMapper();
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
            log.warning("Se recibio una fecha incorrecta " + e.getMessage());
            throw new InvalidDateException();
        }

        postRepository.create(user, date, product, postDto.getCategory(), postDto.getPrice());

        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Product Created!");

        return dto;
    }

    @Override
    public PostListDTO getPostsByFollowedUsers(Long userId, String order) {
        // esta linea solo se usa para que lance la excepcion si el userId esta desactivado
        userService.findById(userId);

        if(order != null && !order.equals("date_asc") && !order.equals("date_desc")) {
            log.warning("Se recibieron parametros inesperados: " + order);
            throw new InvalidArgumentException("Invalid sorting Parameter. Must be order_desc or order_asc");
        }

        List<User> followedUsers = followRepository.findFollowedByUserId(userId);
        PostListDTO postListDTO = new PostListDTO(userId, null);
        List<PostDTO> internalPostList = new ArrayList<>();

        for(User v : followedUsers) {
            this.postRepository.getAllPostsByUserWithinTimespan(v, 14)
                    .forEach(p -> {
                        if (!p.getDeactivated())
                            internalPostList.add(new PostDTO(p));
                    });
        }


        List<PostDTO> sortedAscPostList = internalPostList.stream()
                .sorted(Comparator.comparing(PostDTO::getDate))
                .collect(Collectors.toList());

        if(order != null && order.equals("date_desc")) {
            Collections.reverse(sortedAscPostList);
        }

        postListDTO.setPosts(sortedAscPostList);

        return postListDTO;
    }

    @Override
    public ResponseDTO createPostPromo(PostPromoDTO dto) {
        User user = userService.findById(dto.getUserId());
        Post post = mapper.map(dto, Post.class);
        post.setUser(user);
        postRepository.createPostPromo(post);
        ResponseDTO res = new ResponseDTO();
        res.setMessage("Product created!");
        return res;
    }

    @Override
    public PromoProductCountDTO getUserPromoPosts(Long id) {
        User u = userService.findById(id);
        PromoProductCountDTO dto = new PromoProductCountDTO();
        dto.setUserId(id);
        dto.setUserName(u.getUserName());
        dto.setPromoProductsCount(postRepository.getUserPromoPostsCount(id));
        return dto;
    }
}
