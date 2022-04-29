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
import java.util.Comparator;
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
        User user = this.getUser(postCreateDTO.getUser_id());

        this.updatePost(post, user);
        return new PostCreatedDTO("Se ha creado el Post con éxito");
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.getAll();
        return products.stream()
                .map(product ->  modelMapper.map(product, ProductResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserPostResponseDTO getAllPostsByFollowerId(int userId, String order){
        User user = this.getUser(userId);
        List<User> followed = user.getFollowed();
        List<Post> posts = new ArrayList<>();

        followed.forEach(follow -> {
            follow.getPosts().forEach(post ->{
                long dias = DAYS.between(post.getDate(), LocalDate.now());
                if(dias <= 15) posts.add(post);
            });
        });
        posts.sort((post1, post2) -> (order.equals("date_asc")) ? post1.getDate().compareTo(post2.getDate()) :
                post2.getDate().compareTo(post1.getDate()));

        return new UserPostResponseDTO(userId,
                posts.stream().map(post -> modelMapper.map(post, PostResponseDTO.class)).collect(Collectors.toList()));
    }

    @Override
    public List<PostResponseDTO> getAllPosts(){
        List<Post> posts = postRepository.getAll();

        return posts.stream().map(post -> modelMapper.map(post, PostResponseDTO.class)).collect(Collectors.toList());
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
        User user = this.getUser(userId);

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
        User user = this.getUser(userId);
        List<Post> posts = user.getPosts().stream()
                .filter(Post::getHasPromo)
                .collect(Collectors.toList());

        userProductPromoDTO.setUserId(user.getUser_id());
        userProductPromoDTO.setUserName(user.getUser_name());
        userProductPromoDTO.setPosts(posts);
        return userProductPromoDTO;
    }

    private void updatePost(Post post, User user) {
        Optional<Product> product = productRepository.getById(post.getDetail().getProductId());
        if(product.isEmpty()){
            productRepository.add(post.getDetail());
        }else {
            post.setDetail(product.get());
        }
        postRepository.add(post);
        user.agregarPost(post);
    }

    private User getUser(int userId) {
        return userRepository.getById(userId)
                .orElseThrow(() -> new UserNotFoundPostException("El usuario no fue encontrado"));
    }
}
