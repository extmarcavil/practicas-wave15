package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.*;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserNotFoundException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.PromoPost;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IUserRepository;
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

    private final IUserRepository useRepository;

    @Autowired
    public ProductServiceImpl(IUserRepository useRepository) {
        this.useRepository = useRepository;
    }

    @Override
    public ResponseEntity<SuccessDTO> savePost(RequestPostDTO requestPostDto) {
        if (useRepository.existsById(requestPostDto.getUser_id())) {
            Post postToSaved = Post.from(requestPostDto);
            User user = useRepository.getUser(requestPostDto.getUser_id());
            user.getPosts().add(postToSaved);
            String message = String.format("Post with ID: %s was saved successfully", postToSaved.getId());
            return new ResponseEntity<>(new SuccessDTO(message), HttpStatus.CREATED);
        }
        throw new UserNotFoundException(requestPostDto.getUser_id());
    }

    @Override
    public ResponseEntity<RecentlyPostDTO> getPostsLastTwoWeekById(Integer id, String order) {

        List<ResponsePostDTO> posts = useRepository.getUser(id).getFollowed().stream()
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
        if (useRepository.existsById(requestPromoPostDto.getUser_id())) {
            PromoPost promoPostToSaved = PromoPost.from(requestPromoPostDto);
            User user = useRepository.getUser(requestPromoPostDto.getUser_id());
            user.getPromoPost().add(promoPostToSaved);
            String message = String.format("Promo Post with ID: %s was saved successfully", promoPostToSaved.getId());
            return new ResponseEntity<>(new SuccessDTO(message), HttpStatus.CREATED);
        }
        throw new UserNotFoundException(requestPromoPostDto.getUser_id());
    }

    @Override
    public ResponseEntity<ListPromoPostDTO> getPromoPostsById(Integer id, String order) {
        List<ResponsePromoPostDTO> promoPosts = useRepository.getUser(id)
                                                             .getPromoPost()
                                                             .stream()
                                                             .map(ResponsePromoPostDTO::from)
                                                             .sorted(orderNameProduct(order))
                                                             .collect(Collectors.toList());

        return new ResponseEntity<>(ListPromoPostDTO.from(id, promoPosts), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CantPromoPostDTO> getCantPromoPostsById(Integer id) {
           String name = useRepository.getUser(id).getName();
           Integer cantidad = useRepository.getUser(id)
                                           .getPromoPost()
                                           .stream()
                                           .map(ResponsePromoPostDTO::from)
                                           .collect(Collectors.toList())
                                           .size();

        return new ResponseEntity<>(CantPromoPostDTO.from(id, name ,cantidad), HttpStatus.OK);
    }

    private Comparator<? super ResponsePostDTO> orderNameProduct(String order) {
        if (order.equals("name_asc"))
            return Comparator.comparing(x -> x.getDetail().getName());
        else
            return (x, y) -> -x.getDetail().getName().compareToIgnoreCase(y.getDetail().getName());
    }
}
