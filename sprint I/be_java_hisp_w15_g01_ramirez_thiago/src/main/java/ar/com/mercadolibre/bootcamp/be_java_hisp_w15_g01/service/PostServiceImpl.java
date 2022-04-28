package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidArgumentException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidDateException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.PostPromo;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
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
            throw new InvalidDateException();
        }

        Post createdPost = postRepository.create(user, date, product, postDto.getCategory(), postDto.getPrice());
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Product Created!");

        return dto;
    }


    @Override
    public ResponseDTO createPostPromo(PromotionProductsDTO postPromoDto) {
        User user = userService.findById(postPromoDto.getUserId());
        ProductDTO detail = postPromoDto.getDetail();

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
            date = LocalDate.parse(postPromoDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch(DateTimeException e) {
            throw new InvalidDateException();
        }

        PostPromo createdPost = postRepository.createPostPromo(user, date, product, postPromoDto.getCategory(), postPromoDto.getPrice(), postPromoDto.isHasPromo(), postPromoDto.getDiscount());
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Product Created!");

        return dto;
    }

    @Override
    public PostListDTO getPostsByFollowedUsers(Long userId, String order) {

        if(order != null && !order.equals("date_asc") && !order.equals("date_desc")) {
            throw new InvalidArgumentException("Invalid sorting Parameter. Must be order_desc or order_asc");
        }

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

        if(order != null && order.equals("date_desc")) {
            Collections.reverse(sortedAscPostList);
        }

        postListDTO.setPosts(sortedAscPostList);

        return postListDTO;
    }

    @Override
    public PromotionProductsCountDTO howManyProductsPromoHave(Long userID) {
        User user = this.userService.findById(userID);
        Integer promoPostCount = this.postRepository
                .getAllPromoPostsByID(userID)
                .size();

        PromotionProductsCountDTO dto = new PromotionProductsCountDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setPromoProductsCount(promoPostCount);
        return dto;
    }

    public PostPromoListDTO getListPromoPost(Long userID){
        User user = this.userService.findById(userID);
        List<PostPromo> publicationList = postRepository.getAllPromoPostsByID(userID);

        List<PromotionProductsDTO> listaPromoProduct = publicationList.stream()
                .map(publication -> {
                    PromotionProductsDTO p = new PromotionProductsDTO();
                    p.setDate(publication.getDate().toString());
                    p.setPostId(publication.getPostId());
                    p.setDetail(mapper.map(publication.getDetail(), ProductDTO.class));
                    p.setPrice(publication.getPrice());
                    p.setCategory(publication.getCategory());
                    p.setHasPromo(publication.isHasPromo());
                    p.setDiscount(publication.getDiscount());
                    return p;
                }).collect(Collectors.toList());

        PostPromoListDTO postPromo = new PostPromoListDTO();
        postPromo.setPosts(listaPromoProduct);
        postPromo.setUserId(user.getUserId());
        return postPromo;
    }


}
