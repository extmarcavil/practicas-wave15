package com.example.be_java_hisp_w15_g07.service;


import com.example.be_java_hisp_w15_g07.dto.request.NewPromoPostDTO;
import com.example.be_java_hisp_w15_g07.dto.response.*;
import com.example.be_java_hisp_w15_g07.exception.BadRequestException;
import com.example.be_java_hisp_w15_g07.model.Post;
import com.example.be_java_hisp_w15_g07.model.User;

import com.example.be_java_hisp_w15_g07.dto.request.NewPostDTO;

import com.example.be_java_hisp_w15_g07.repository.IUserRepository;
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
     * create new post
     *
     * @param postDTO {@link NewPostDTO}
     */
    public void newPost(NewPostDTO postDTO){
        Post post = modelMapper.map(postDTO, Post.class);
        userRepository.newPost(postDTO.getUserId(), post);
    }

    public void newPromoPost(NewPromoPostDTO promoPostDTO){
            Post post = modelMapper.map(promoPostDTO, Post.class);
        userRepository.newPost(promoPostDTO.getUserId(), post);
    }

    public UserFollowedPromoPostsDTO getFollowedPromoPosts(Integer userId) {
        List<Post> listPosts = new ArrayList<>();
        List<Post> listPromo = new ArrayList<>();

        listPosts = userRepository.findById(userId).getPosts();
            for (Post p : listPosts
                 ) {
                if(p.getDiscount() > 0){
                    listPromo.add(p);
                }
            }
        List<PromoPostDTO> listFollowedPromoPosts = listPromo.stream().map(v -> modelMapper.map(v, PromoPostDTO.class )).collect(Collectors.toList());

        return new UserFollowedPromoPostsDTO(userId, listFollowedPromoPosts);
    }

    /**
     * promo post count
     *
     * @param idUser idus
     * @return {@link FollowersCountDTO}
     * @see FollowersCountDTO
     */
    public PromoCountDTO getpromoPostCount(Integer idUser){
        User user = userRepository.findById(idUser);
        PromoCountDTO count = new PromoCountDTO(user.getUserId(), user.getUserName(), getFollowedPromoPosts(idUser).posts.size());
        return count;
    }
}
