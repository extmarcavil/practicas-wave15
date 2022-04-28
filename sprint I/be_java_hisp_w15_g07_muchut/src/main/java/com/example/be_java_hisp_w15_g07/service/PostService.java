package com.example.be_java_hisp_w15_g07.service;


import com.example.be_java_hisp_w15_g07.dto.response.PostDTO;
import com.example.be_java_hisp_w15_g07.dto.response.PromoPostsDTO;
import com.example.be_java_hisp_w15_g07.dto.response.UserFollowedPostsDTO;
import com.example.be_java_hisp_w15_g07.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.User;

import com.example.be_java_hisp_w15_g07.dto.request.NewPostDTO;

import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;


import java.time.LocalDate;
import java.util.*;
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

    @Override
    public PromoPostsDTO getPromoProducts(Integer userId) {
        System.out.println("-----> el userId: " + userId);
        User user = userRepository.findById(userId);
        if (user.getPosts().isEmpty()) {
            throw new BadRequestException("This user is not a seller");
        }
        Integer count = user.getPosts().stream()
                .filter(e -> e.isHasPromo())
                .collect(Collectors.toList())
                .size();
        PromoPostsDTO response = new PromoPostsDTO(userId, user.getUserName(), count);
        return response;
    }

    /**
     * create new post
     *
     * @param postDTO {@link NewPostDTO}
     * modified by Sebastián Muchut
     */
    public void newPost(NewPostDTO postDTO){
        if(postDTO.getDiscount() < 0) {
            throw new BadRequestException("Discounts cannot be negative number");
        }
        if(postDTO.getDiscount() >= 1) {
            throw new BadRequestException("Discounts must be a number between 0 and 1");
        }
        Post post = modelMapper.map(postDTO, Post.class);
        userRepository.newPost(postDTO.getUserId(), post);
    }
}
