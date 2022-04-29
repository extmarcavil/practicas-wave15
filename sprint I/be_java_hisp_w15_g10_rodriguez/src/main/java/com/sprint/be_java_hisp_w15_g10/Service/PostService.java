package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.ProductCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.PromoPostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.Exception.DuplicatedEntityException;
import com.sprint.be_java_hisp_w15_g10.Exception.NotAPromoException;
import com.sprint.be_java_hisp_w15_g10.Model.Category;
import com.sprint.be_java_hisp_w15_g10.Model.Post;
import com.sprint.be_java_hisp_w15_g10.Model.Product;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Slf4j
@Service
public class PostService implements IPostService{
    private final Utils utils;

    public PostService(Utils utils) {
        this.utils = utils;
    }

    private PostCreatedDTO addPost(Post post, User user){
        Optional<Product> product = utils.getProductUtils().getEntityRepository().getById(post.getDetail().getProduct_id());
        if(product.isEmpty()) utils.getProductUtils().getEntityRepository().add(post.getDetail());
        else post.setDetail(product.get());
        utils.getPostUtils().getEntityRepository().add(post);
        user.agregarPost(post);
        return new PostCreatedDTO("Se ha creado el Post con éxito");
    }

    @Override
    public PostCreatedDTO createPost(PostCreateDTO postCreateDTO) {
        Post post = utils.getPostUtils().convertToEntity(postCreateDTO, new Post());
        post.setPost_id(utils.getPostUtils().getEntityRepository().getNextId());
        post.setCategory(utils.getCategoryOrThrow(postCreateDTO.getCategory_id()));
        return addPost(post, utils.getUserOrThrow(postCreateDTO.getUser_id()));
    }

    @Override
    public ProductCreatedDTO createProduct(ProductCreateDTO productCreateDTO) {
        if(utils.getProductUtils().addObject(utils.getProductUtils().convertToEntity(productCreateDTO, new Product()), productCreateDTO.toString()))
            return new ProductCreatedDTO("Se ha creado el producto " + productCreateDTO.getProduct_name() + " con éxito.");
        throw new DuplicatedEntityException("El producto " + productCreateDTO.getProduct_name() + " ya se encuentra registrado");
    }

    @Override
    public PostCreatedDTO createPromoPost(PromoPostCreateDTO postCreateDTO) {
        Post post = utils.getPostUtils().convertToEntity(postCreateDTO, new Post());
        post.setPost_id(utils.getPostUtils().getEntityRepository().getNextId());
        post.setCategory(utils.getCategoryOrThrow(postCreateDTO.getCategory_id()));
        if(!postCreateDTO.getHas_promo()) throw new NotAPromoException("Post sin promoción Invalido");
        return addPost(post, utils.getUserOrThrow(postCreateDTO.getUser_id()));
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return utils.getProductUtils().convertToListOfDTO(utils.getProductUtils().getAllObjects(), new ProductResponseDTO());
    }

    @Override
    public UserPostResponseDTO getAllPostsByFollowerId(int userId, String order){
        List<Post> posts = new ArrayList<>();
        utils.getUserOrThrow(userId).getFollowed().forEach(follow -> {
            follow.getPosts().forEach(post ->{
                long dias = DAYS.between(post.getDate(), LocalDate.now());
                if(dias <= 15) posts.add(post);
            });
        });
        if(order.equals("date_asc")) posts.sort(Comparator.comparing(Post::getDate));
        else if(order.equals("date_desc")) posts.sort((post1, post2) -> post2.getDate().compareTo(post1.getDate()));
        return new UserPostResponseDTO(userId, utils.getPostUtils().convertToListOfDTO(posts, new PostResponseDTO()));}

    @Override
    public UserPromoPostResponseDTO getAllPromoPostsBySellerId(int userId, String order) {
        User user = utils.getUserOrThrow(userId);
        List<Post> posts = user.getPosts().stream()
                .filter(Post::isHas_promo)
                .collect(Collectors.toList());
        if(order.equals("date_asc")) posts.sort(Comparator.comparing(Post::getDate));
        else if(order.equals("date_desc")) posts.sort((post1, post2) -> post2.getDate().compareTo(post1.getDate()));
        return new UserPromoPostResponseDTO(userId, utils.getPostUtils().convertToListOfDTO(posts, new PromoPostResponseDTO()));
    }

    @Override
    public List<PostResponseDTO> getAllPosts(){
        return utils.getPostUtils().convertToListOfDTO(utils.getPostUtils().getAllObjects(), new PostResponseDTO());
    }
}
