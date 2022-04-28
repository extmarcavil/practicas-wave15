package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.service;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.dto.*;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidArgumentException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.InvalidDateException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.exceptions.NotFoundException;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Post;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Product;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.FollowRepository;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl<T> implements PostService {

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
        postRepository.create(user, date, product, postDto.getCategory(), postDto.getPrice(), null, null);
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Product Created!");
        return dto;
    }

    @Override
    public ResponseDTO createPromoPost(PromoPostDTO postDto) {
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
        postRepository.create(user, date, product, postDto.getCategory(), postDto.getPrice(), postDto.getHasPromo(), postDto.getDiscount());
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
    public CountDTO countPromoPost(Long userId) {
        User user = userService.findById(userId);
        int count = postRepository.getListOfPromoPosts(userId).size();
        CountDTO countDTO = new CountDTO();
        countDTO.setUserId(userId);
        countDTO.setCount(count);
        countDTO.setUserName(user.getUserName());
        return countDTO;
    }



    @Override
    public PromoPostListDTO allPromoProducts(Long userId) {
         User user = userService.findById(userId);

        PromoPostListDTO postListDTO = new PromoPostListDTO();
        List<PromoPostDTO> internalPostList = new ArrayList<>();

        postRepository.getListOfPromoPosts(userId).forEach(p -> internalPostList.add(new PromoPostDTO(p)));
        postListDTO.setPosts(internalPostList);
        postListDTO.setUserName(user.getUserName());
        postListDTO.setUserId(user.getUserId());
        return postListDTO;

    }

    // ----------------------------------------------------------------
    @Override
    public Product findProductById(Long id) {
        Optional<Product> ou = postRepository.findProductById(id);
        if (ou.isPresent()) {
            return ou.get();
        } else {
            throw new NotFoundException("The product does not exists");
        }
    }
    @Override
    public ResponseDTO addProductToPurchase(Long userId, Long productId){
        User user = userService.findById(userId);
        Product product = findProductById(productId);
        postRepository.addProductToPurchase(user, product);
        ResponseDTO dto = new ResponseDTO();
        dto.setMessage("Product added to cart!");
        return dto;
    }

    @Override
    public List<Product> showAllProductsOfPurchase(Long userId){
        User user = userService.findById(userId);
        List<Product> products = postRepository.getListOfProducts(user.getUserId());
        return products;
    }

}
