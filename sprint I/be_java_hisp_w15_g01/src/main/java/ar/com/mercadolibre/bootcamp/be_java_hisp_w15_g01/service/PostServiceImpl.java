package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidArgumentException;
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

    /**
     * PostService
     * Crea un post
     *
     * @param postDto El post dto a crear
     */
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

        Post createdPost = postRepository.create(user, date, product, postDto.getCategory(), postDto.getPrice(), postDto.getDiscount(), postDto.getHasPromo());

        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Product Created!");

        return dto;
    }

    /**
     * PostService
     * Obtiene todos los posts de usuarios que siguen a userId
     *
     * @param userId El id del usuario a buscar
     * @param order El orden de los resultados
     */
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

    /**
     * PostService
     * Obtiene el conteo de posts de un usuario
     *
     * @param userId El id del usuario a buscar
     * @param hasPromo Obtener solo publicaciones con promoción
     * @param daysInterval Intervalo en días (si aplica)
     */
    @Override
    public VendorInfoDTO getPostCount(Long userId, Boolean hasPromo, Integer daysInterval) {
        User vendor = userService.findById(userId);

        long postCount = this.postRepository.getAllPostsByUserWithinTimespan(vendor, daysInterval).stream()
                .filter(p -> !hasPromo || p.getHasPromo()).count();

        // Lo ideal seria que el campo se llamara "count" a secas y poder reutilizarlo en varios metodos pero la firma especifica que se llama "promo_products_count"

        Long totalCount = null, promoCount = null;

        if(!hasPromo)
            totalCount = postCount;
        else
            promoCount = postCount;

        return new VendorInfoDTO(vendor.getUserId(), vendor.getUserName(), promoCount, totalCount);
    }

    /**
     * PostService
     * Obtener publicaciones en promocion de un usuario especifico
     *
     * @param userId El id del usuario a buscar
     */
    @Override
    public PostListDTO getPromoPostsByUser(Long userId) {
        User vendor = userService.findById(userId);

        List<PostDTO> posts = this.postRepository.getAllPostsByUserWithinTimespan(vendor, null).stream()
                .filter(Post::getHasPromo)
                .map(PostDTO::new)
                .collect(Collectors.toList());

        return new PostListDTO(vendor.getUserId(), vendor.getUserName(), posts);
    }

    /**
     * PostService
     * Obtener una lista de vendedores con más publicaciones en cierto intervalo, ordenado de manera descendente
     *
     * @param daysInterval Intervalo en días
     */
    @Override
    public List<VendorInfoDTO> getPosterRanking(Integer daysInterval) {
        return userService.getAllUsers()
                .stream()
                .map(u -> getPostCount(u.getUserId(), false, daysInterval))
                .sorted((a,b) -> b.getTotalCount().compareTo(a.getTotalCount()))
                .collect(Collectors.toList());
    }
}
