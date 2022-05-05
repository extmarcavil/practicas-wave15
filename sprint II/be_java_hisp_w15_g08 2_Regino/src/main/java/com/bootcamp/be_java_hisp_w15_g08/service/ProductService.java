package com.bootcamp.be_java_hisp_w15_g08.service;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.NewPostDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostListDTO;
import com.bootcamp.be_java_hisp_w15_g08.dto.response.PostNotUserIdDTO;
import com.bootcamp.be_java_hisp_w15_g08.model.Post;
import com.bootcamp.be_java_hisp_w15_g08.model.User;
import com.bootcamp.be_java_hisp_w15_g08.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w15_g08.utils.SortUsers;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.util.stream.Collectors.toList;

@Service
public class ProductService implements IProductService {

    IUserRepository repository;
    ModelMapper mapper;
    private int idsPost;

    public ProductService(IUserRepository repository) {
        this.repository = repository;
        mapper = new ModelMapper();
        idsPost = 1;
    }


    @Override
    public PostNotUserIdDTO addPost(NewPostDTO newPostDTO) {
        User user = repository.findUser(newPostDTO.getUser_id());
        Post post = mapper.map(newPostDTO, Post.class);
        post.setPostID(idsPost++);
        user.addPost(post);
        return mapper.map(post, PostNotUserIdDTO.class);
    }

    @Override
    public PostListDTO getSellersLastsPosts(Integer userId, String order) {
        User user = repository.findUser(userId);
        List<User> followedUsers = user.getFollowing();
        List<Post> posts1 = new ArrayList<>();
        followedUsers.forEach(user2 -> {
            List<Post> postsFlitrado = user2.getPosts()
                    .values()
                    .stream()
                    .filter(post -> DAYS.between(post.getDate(), LocalDate.now()) < 14)
                    .collect(Collectors.toList());
            posts1.addAll(postsFlitrado);
        });

        PostListDTO postListDTO = new PostListDTO();
        postListDTO.setUser_id(userId);

        List<PostNotUserIdDTO> postNotUserIdDTOS = posts1.stream()
                .map(post -> mapper.map(post, PostNotUserIdDTO.class))
                .collect(toList());
        if (order != null) {
            postNotUserIdDTOS = SortUsers.orderDate(postNotUserIdDTOS, order);
        }
        postListDTO.setPosts(postNotUserIdDTOS);
        return postListDTO;
    }
}