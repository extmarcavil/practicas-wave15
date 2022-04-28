package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidArgumentException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidDateException;
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

        User user;
        user = userService.findById(postDto.getUserId());
        Product product = createProduct(postDto.getDetail());
        LocalDate date = checkDateValid(postDto.getDate());
        postRepository.createPost(user, date, product, postDto.getCategory(), postDto.getPrice(), null , null);

        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Product Created!");

        return dto;
    }

    @Override
    public ResponseDTO createPromoPost(PromoPostDTO promoPostDto) {

        User user = userService.findById(promoPostDto.getUserId());
        Product product = createProduct(promoPostDto.getDetail());
        LocalDate date = checkDateValid(promoPostDto.getDate());
        postRepository.createPost(user, date, product, promoPostDto.getCategory(), promoPostDto.getPrice(), promoPostDto.getHasPromo(), promoPostDto.getDiscount());

        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Promo Product Created!");

        return dto;
    }

    private Product createProduct(ProductDTO detail) {
        Product product = new Product(
                detail.getProductId(),
                detail.getProductName(),
                detail.getType(),
                detail.getBrand(),
                detail.getColor(),
                detail.getNotes()
        );

        return product;
    }

    private LocalDate checkDateValid(String date) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch(DateTimeException e) {
            throw new InvalidDateException();
        }
        return localDate;
    }

    @Override
    public PostListDTO getPostsByFollowedUsers(Long userId, String order) {

        if(order != null && !order.equals("date_asc") && !order.equals("date_desc")) {
            throw new InvalidArgumentException("Invalid sorting Parameter. Must be date_desc or date_asc");
        }

        List<User> followedUsers = followRepository.findFollowedByUserId(userId);
        PostListDTO postListDTO = new PostListDTO(userId, null);
        List<PostDTO> internalPostList = new ArrayList<>();

        for(User v : followedUsers) {
            this.postRepository.getAllPostsByUserWithinTimeStamp(v, 14)
                    .forEach(p -> internalPostList.add(new PostDTO(p)));
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
    public PromoPostCountDTO howManyPromoPostById(Long userId) {

        User user = userService.findById(userId);

        PromoPostCountDTO dto = new PromoPostCountDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setPromoProductsCount(postRepository.howManyPromoPostById(userId));

        return dto;
    }

    @Override
    public ResponseDTO updatePost(Long postId, PromoPostDTO postDTO) {

        User user = userService.findById(postDTO.getUserId());
        Product product = createProduct(postDTO.getDetail());
        LocalDate date = checkDateValid(postDTO.getDate());
        postRepository.updatePost(postId, user, date, product, postDTO.getCategory(), postDTO.getPrice(), postDTO.getHasPromo(), postDTO.getDiscount());

        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Post Updated!");

        return dto;
    }

    @Override
    public PostListDetailDTO getAllPostsByUserId(Long userId) {

        PostListDetailDTO postListDTO = new PostListDetailDTO(userId, null);
        List<PromoPostDTO> internalPostList = new ArrayList<>();

        this.postRepository.getAllPostsByUserId(userId)
                .forEach(p -> internalPostList.add(new PromoPostDTO(p)));

        postListDTO.setPosts(internalPostList);

        return postListDTO;
    }



}
