package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.*;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostPromoDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserNotFoundException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
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
import java.util.stream.Stream;

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
        //Ordenamiento por fecha de forma ascendente y descendente
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
    public ResponseEntity<SuccessDTO> savePostPromo(RequestPostPromoDTO requestPostPromoDTO) {
        if (useRepository.existsById(requestPostPromoDTO.getUser_id())) {
            Post postToSaved = Post.fromPromo(requestPostPromoDTO);
            User user = useRepository.getUser(requestPostPromoDTO.getUser_id());
            user.getPosts().add(postToSaved);
            String message = String.format("Post with promotion: %s was saved successfully", postToSaved.getId());
            return new ResponseEntity<>(new SuccessDTO(message), HttpStatus.CREATED);
        }
        throw new UserNotFoundException(requestPostPromoDTO.getUser_id());
    }

    @Override
    public PostCountPromoDTO getCountPromotion(Integer userId) {
        User userSeller = this.useRepository.getUser(userId);
        return new PostCountPromoDTO(userSeller.getId(), userSeller.getName(),
                (int) userSeller.getPosts().stream()
                        .filter(p -> p.getHas_promo() == true)
                        .count());
    }

    public ResponseEntity<RecentlyPostPromoDTO> getPostsPromotion(Integer id, String order){
        User userseller = this.useRepository.getUser(id);
        List<ResponsePostPromoDTO> postsWithPromo = userseller.getPosts().stream()
                .filter(p ->p.getHas_promo() == true)
                .map(ResponsePostPromoDTO::from)
                .collect(Collectors.toList());
        //Ordenamiento por nombre del producto de forma ascendente y descendente
        if(order.equals("name_asc"))
            postsWithPromo.sort(Comparator.comparing(a -> a.getDetail().getName()));
        else
            postsWithPromo.sort((a, b) -> -a.getDetail().getName().compareToIgnoreCase(b.getDetail().getName()));

        return new ResponseEntity<>(RecentlyPostPromoDTO.from(id, userseller.getName(), postsWithPromo), HttpStatus.OK);
    }

}
