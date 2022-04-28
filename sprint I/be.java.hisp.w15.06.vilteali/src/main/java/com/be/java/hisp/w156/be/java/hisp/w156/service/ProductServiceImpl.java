package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.ResponsePostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponseCountPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponsePromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.DiscountLessThanZeroException;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.PriceLessThanZeroException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
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

    private final IUserRepository userRepository;

    @Autowired
    public ProductServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<SuccessDTO> savePost(RequestPostDTO postDTO) {
        Post postCreated = userRepository.findUserByIdForUpdate(postDTO.getUser_id(), user -> {
            validatePrinceAndDiscountGreaterThanZero(postDTO.getDiscount(), postDTO.getPrice());
            Post newPost = Post.from(postDTO);
            user.addNewPost(newPost);
            return newPost;
        });

        String message = String.format("Post with ID: %s was saved successfully", postCreated.getId()); // check this....
        return new ResponseEntity<>(new SuccessDTO(message), HttpStatus.CREATED);
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

    @Override
    public ResponseEntity<ResponseCountPromoPostDTO> getCountPromoPostsById(Integer user_id) {
        User user = userRepository.getUser(user_id);

        long quantity = user.getPosts().stream()
                .filter(Post::isHas_promo)
                .count();

        return new ResponseEntity<>(ResponseCountPromoPostDTO.from(user, quantity), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponsePromoPostDTO> getAllPromoPostById(Integer user_id, String order) {
        User user = userRepository.getUser(user_id);

        List<ResponsePostDTO> posts = user.getPosts().stream()
                .filter(Post::isHas_promo)
                .map(ResponsePostDTO::from)
                .sorted(orderByNameDetail(order))
                .collect(Collectors.toList());

        return new ResponseEntity<>(ResponsePromoPostDTO.from(user, posts), HttpStatus.OK);
    }

    private Comparator<? super ResponsePostDTO> orderByNameDetail(String order) {
        if (order.equals("name_asc")) {
            return Comparator.comparing(post -> post.getDetail().getName());
        } else {
            return (a, b) -> -a.getDetail().getName().compareToIgnoreCase(b.getDetail().getName());
        }
    }

    private void validatePrinceAndDiscountGreaterThanZero(Double discount, Double price) {
        if (discount != null && discount.compareTo(0.0) <= 0)  {
            throw new DiscountLessThanZeroException(discount);
        }
        if (price != null && price.compareTo(0.0) <= 0) {
            throw new PriceLessThanZeroException(price);
        }
    }

    private boolean byLastTwoWeek(LocalDate date) {
        long days = ChronoUnit.DAYS.between(date, LocalDate.now());
        return days <= 14;
    }
}
