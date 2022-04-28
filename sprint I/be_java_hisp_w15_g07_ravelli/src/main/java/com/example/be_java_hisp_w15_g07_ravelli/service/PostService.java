package com.example.be_java_hisp_w15_g07_ravelli.service;


import com.example.be_java_hisp_w15_g07_ravelli.dto.response.*;
import com.example.be_java_hisp_w15_g07_ravelli.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07_ravelli.model.Post;
import com.example.be_java_hisp_w15_g07_ravelli.model.User;

import com.example.be_java_hisp_w15_g07_ravelli.dto.request.NewPostDTO;

import com.example.be_java_hisp_w15_g07_ravelli.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService{

    private IUserRepository userRepository;
    private ModelMapper modelMapper;

    public PostService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        modelMapper = new ModelMapper();
    }

    /**
     * get followed posts optionally ordered by date, by user
     *
     * @param userId Integer
     * @param order String
     * @return {@link UserFollowedPostsDTO}
     * @see UserFollowedPostsDTO
     */
    @Override
    public UserFollowedPostsDTO getFollowedPosts(Integer userId, String order) {
        List<Post> listPosts = new ArrayList<>();
        for (User user : userRepository.findById(userId).getFollowed()) {
            listPosts.addAll(user.getPosts());
        }
        LocalDate now = LocalDate.now();
        List<Post> listPostsOrdered = new ArrayList<>();
        for (Post p : listPosts) {
            if (ChronoUnit.DAYS.between(p.getDate(), now) < 16) {
                listPostsOrdered.add(p);
            }
        }

        if (order.equals("date_desc")) {
            listPostsOrdered = listPostsOrdered.stream()
                        .sorted(Comparator.comparing(Post::getDate).reversed())
                        .collect(Collectors.toList());
        }
        if (order.equals("date_asc")) {
            listPostsOrdered = listPostsOrdered.stream()
                        .sorted(Comparator.comparing(Post::getDate))
                        .collect(Collectors.toList());
        }


        List<PostDTO> listFollowedPosts = listPostsOrdered.stream().map(v -> modelMapper.map(v, PostDTO.class)).collect(Collectors.toList());

        return new UserFollowedPostsDTO(userId, listFollowedPosts);
    }

    /**
     * get promo products count by user id
     *
     * @param userId Integer
     * @return {@link PromoProductsCountDTO}
     * @see PromoProductsCountDTO
     */
    @Override
    public PromoProductsCountDTO getPromoProductsCountByUserId(Integer userId) {
        User user = userRepository.findById(userId);
        if(user.getPosts().isEmpty()){
            throw new BadRequestException("Este usuario no es vendedor");
        }
        Long promoProductsCount = userRepository.getPromoProductsCount(userId);
        return new PromoProductsCountDTO(user.getUserId(), user.getUserName(), promoProductsCount);
    }

    /**
     * create new post
     *
     * @param postDTO {@link NewPostDTO}
     */
    public void newPost(NewPostDTO postDTO){
        Post post = modelMapper.map(postDTO, Post.class);
        if(post.getHasPromo() == null){
            post.setHasPromo(false);
            post.setDiscount(0d);
        }
        userRepository.newPost(postDTO.getUserId(), post);
    }

    /**
     * get promo posts by userId
     *
     * @param userId Integer
     * @return {@link UserFollowedPostsDTO}
     * @see UserFollowedPostsDTO
     */
    @Override
    public UserPromoPosts getPromoPosts(Integer userId) {
        User user = userRepository.findById(userId);
        if(user.getPosts().isEmpty()){
            throw new BadRequestException("Este usuario no es un vendedor");
        }
        List<Post> listPromoPosts = user.getPosts().stream().filter(Post::getHasPromo).collect(Collectors.toList());
        List<PromoPostDTO> resultPosts = listPromoPosts.stream().map(v -> modelMapper.map(v, PromoPostDTO.class)).collect(Collectors.toList());
        return new UserPromoPosts(userId, user.getUserName(), resultPosts);
    }
}
