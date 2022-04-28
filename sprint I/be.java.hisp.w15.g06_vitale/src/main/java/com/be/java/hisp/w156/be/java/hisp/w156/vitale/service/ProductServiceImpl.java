package com.be.java.hisp.w156.be.java.hisp.w156.vitale.service;

import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.request.RequestPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.response.*;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.exception.UserNotFoundException;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.model.Product;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.model.User;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    private final IUserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(IUserRepository userRepository) {

        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public ResponseEntity<SuccessDTO> savePost(RequestPostDTO requestPostDto) {
        if (userRepository.existsById(requestPostDto.getUser_id())) {
            Post postToSaved = Post.from(requestPostDto);
            User user = userRepository.getUser(requestPostDto.getUser_id());
            user.getPosts().add(postToSaved);
            String message = String.format("Post with ID: %s was saved successfully", postToSaved.getPost_id());
            return new ResponseEntity<>(new SuccessDTO(message), HttpStatus.CREATED);
        }
        throw new UserNotFoundException(requestPostDto.getUser_id());
    }

    @Override
    public ResponseEntity<RecentlyPostDTO> getPostsLastTwoWeekById(Integer id, String order) {

        List<ResponsePostDTO> posts = userRepository.getUser(id).getFollowed().stream()
               .flatMap(user -> user.getPosts().stream()
                       .filter(post -> byLastTwoWeek(post.getDate())))
               .map(ResponsePostDTO::from)
               .collect(Collectors.toList());

        if(order.equals("date_asc"))
            posts.sort(Comparator.comparing(ResponsePostDTO::getDate));
        else
            posts.sort(Comparator.comparing(ResponsePostDTO::getDate).reversed());

        return new ResponseEntity<>(RecentlyPostDTO.from(id, posts), HttpStatus.OK);
    }

    private boolean byLastTwoWeek(LocalDate date) {
        long days = ChronoUnit.DAYS.between(date, LocalDate.now());
        return days <= 14;
    }

    @Override
    public ResponseEntity<SuccessDTO> savePromoPost(RequestPromoPostDTO requestPromoPostDto) {
        User user = userRepository.getUser(requestPromoPostDto.getUser_id());
        Post promoPost = modelMapper.map(requestPromoPostDto, Post.class);
        promoPost.setPost_id(requestPromoPostDto.getUser_id());
        user.getPosts().add(promoPost);
        String message = String.format("Promo post with ID: %s was saved successfully", promoPost.getPost_id());
        return new ResponseEntity<>(new SuccessDTO(message), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PromoPostsCountDTO> getPromoPostsCount(Integer user_id) {

        User userSeller = this.userRepository.getUser(user_id);

        return new ResponseEntity<>(new PromoPostsCountDTO(userSeller.getId(),
                userSeller.getName(),
                userSeller.getPosts().stream().filter(post -> post.isHas_promo()).collect(Collectors.toList()).size()),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PromoPostsListDTO> getPromoPostsList(Integer user_id, String order) {

        User userSeller = this.userRepository.getUser(user_id);

        List<ResponsePromoPostDTO> posts = userSeller.getPosts().stream()
                .filter(Post::isHas_promo)
                .map(promoPost -> modelMapper.map(promoPost, ResponsePromoPostDTO.class))
                .collect(Collectors.toList());

        if(order.equals("name_asc"))
            posts.sort(Comparator.comparing(ResponsePromoPostDTO::showProductName));
        else
            posts.sort(Comparator.comparing(ResponsePromoPostDTO::showProductName).reversed());

        return new ResponseEntity<>(new PromoPostsListDTO(userSeller.getId(), userSeller.getName(), posts), HttpStatus.OK);

    }
}
