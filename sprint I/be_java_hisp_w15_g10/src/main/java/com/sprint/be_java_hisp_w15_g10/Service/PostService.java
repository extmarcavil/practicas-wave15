package com.sprint.be_java_hisp_w15_g10.Service;

import com.sprint.be_java_hisp_w15_g10.DTO.Request.NewProductWithDiscountDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Request.PostCreateDTO;
import com.sprint.be_java_hisp_w15_g10.DTO.Response.*;
import com.sprint.be_java_hisp_w15_g10.Exception.CategoryNotFoundPostException;
import com.sprint.be_java_hisp_w15_g10.Exception.UserNotFoundException;
import com.sprint.be_java_hisp_w15_g10.Exception.UserNotFoundPostException;
import com.sprint.be_java_hisp_w15_g10.Model.Category;
import com.sprint.be_java_hisp_w15_g10.Model.Post;
import com.sprint.be_java_hisp_w15_g10.Model.Product;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Repository.CategoryRepository;
import com.sprint.be_java_hisp_w15_g10.Repository.PostRepository;
import com.sprint.be_java_hisp_w15_g10.Repository.ProductRepository;
import com.sprint.be_java_hisp_w15_g10.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Slf4j
@Service
public class PostService implements IPostService{
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public PostService(ModelMapper modelMapper, UserRepository userRepository, PostRepository postRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public PostCreatedDTO createPost(PostCreateDTO postCreateDTO){
        Category category = categoryRepository
                .getById(postCreateDTO.getCategory_id())
                .orElseThrow(() -> new CategoryNotFoundPostException("La categoría no fue encontrado"));

        Post post = modelMapper.map(postCreateDTO, Post.class);
        post.setPostId(postRepository.nextIndex());
        post.setCategory(category);
        User user = userRepository.getById(postCreateDTO.getUser_id())
                .orElseThrow(() -> new UserNotFoundPostException("El usuario no fue encontrado"));

        Optional<Product> product = productRepository.getById(post.getDetail().getProductId());
        if(product.isEmpty()){
            productRepository.add(post.getDetail());
        }else {
            post.setDetail(product.get());
        }
        postRepository.add(post);
        user.agregarPost(post);
        return new PostCreatedDTO("Se ha creado el Post con éxito");
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.getAll();
        List<ProductResponseDTO> productResponseDTOS = products.stream()
                .map(product ->  modelMapper.map(product, ProductResponseDTO.class))
                .collect(Collectors.toList());
        return productResponseDTOS;
    }

    @Override
    public UserPostResponseDTO getAllPostsByFollowerId(int userId, String order){
        User user = userRepository.getById(userId)
                .orElseThrow(() -> new UserNotFoundException("El usuario no fue encontrado"));
        List<User> followed = user.getFollowed();
        List<Post> posts = new ArrayList<>();

        followed.forEach(follow -> {
            follow.getPosts().forEach(post ->{
                long dias = DAYS.between(post.getDate(), LocalDate.now());
                if(dias <= 15) posts.add(post);
            });
        });

        if(order.equals("date_asc")) posts.sort((post1, post2) -> post1.getDate().compareTo(post2.getDate()));
        else if(order.equals("date_desc")) posts.sort((post1, post2) -> post2.getDate().compareTo(post2.getDate()));

        UserPostResponseDTO userPostResponseDTO = new UserPostResponseDTO(userId,
                posts.stream().map(post -> modelMapper.map(post, PostResponseDTO.class)).collect(Collectors.toList()));

        return userPostResponseDTO;
    }

    @Override
    public List<PostResponseDTO> getAllPosts(){
        List<Post> posts = postRepository.getAll();
        List<PostResponseDTO> responseDTOS = posts.stream().map(post -> modelMapper.map(post, PostResponseDTO.class)).collect(Collectors.toList());

        return responseDTOS;
    }

    @Override
    public void newProductWithDiscount(NewProductWithDiscountDTO newProductDTO) {
        Post post = modelMapper.map(newProductDTO, Post.class);

        userRepository.getAll().forEach(us -> {
            if (us.getUser_id() == newProductDTO.getUserId()) us.agregarPost(post);
        });

        postRepository.add(post);
    }

    @Override
    public CountPromoProductsOfUserDTO getPromoProductsOfUser(int userId) {
        CountPromoProductsOfUserDTO countPromoProductsOfUserDTO = new CountPromoProductsOfUserDTO();
        User user = userRepository.getById(userId).get();

        List<Post> userPost = user.getPosts()
                .stream().filter(Post::getHasPromo)
                .collect(Collectors.toList());
        countPromoProductsOfUserDTO.setUserId(user.getUser_id());
        countPromoProductsOfUserDTO.setUserName(user.getUser_name());
        countPromoProductsOfUserDTO.setPromoProductosCount(userPost.size());

        return countPromoProductsOfUserDTO;
    }

    @Override
    public UserProductPromoDTO getUserProductPromo(int userId) {
        UserProductPromoDTO userProductPromoDTO = new UserProductPromoDTO();
        User user = userRepository.getById(userId).get();
        List<Post> posts = user.getPosts().stream()
                .filter(Post::getHasPromo)
                .collect(Collectors.toList());

        userProductPromoDTO.setUserId(user.getUser_id());
        userProductPromoDTO.setUserName(user.getUser_name());
        userProductPromoDTO.setPosts(posts);
        return userProductPromoDTO;
    }
}
