package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponsePostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.InvalidOrderException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements IProductService {

    private final IUserRepository userRepository;

    @Autowired
    public ProductServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<SuccessDTO> savePost(RequestPostDTO requestPostDto) {

        Post postCreated = userRepository.findByIdForUpdate(requestPostDto.getUser_id(), user -> {
            Post newPost = Post.from(requestPostDto);
            user.addNewPost(newPost);
            return newPost;
        });

        String message = String.format("Post with ID: %s was saved successfully", postCreated.getPost_id());

        return new ResponseEntity<>(new SuccessDTO(message), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RecentlyPostDTO> getPostsLastTwoWeekById(Integer id, String order) {

        validateDateOrdering(order);

        User user = userRepository.getUser(id);

        List<ResponsePostDTO> posts = Optional.ofNullable(user.getFollowed())
                .orElseGet(Collections::emptyList)
                .stream()
                .flatMap(getPostsFromTheLastTwoWeeks())
                .map(ResponsePostDTO::from)
                .sorted(sortBy(order))
                .collect(Collectors.toList());

        return new ResponseEntity<>(RecentlyPostDTO.from(id, posts), HttpStatus.OK);
    }

    private Comparator<? super ResponsePostDTO> sortBy(String order) {
        return order.equals("date_asc")
                ? Comparator.comparing(ResponsePostDTO::getDate)
                : Comparator.comparing(ResponsePostDTO::getDate).reversed();
    }

    private Function<User, Stream<? extends Post>> getPostsFromTheLastTwoWeeks() {
        return user -> user.getPosts().stream()
                .filter(post -> byLastTwoWeek(post.getDate()));
    }

    private boolean byLastTwoWeek(LocalDate date) {
        long days = ChronoUnit.DAYS.between(date, LocalDate.now());
        return days <= 14;
    }

    private void validateDateOrdering(String order) {
        if (!(order.equals("date_asc") || order.equals("date_desc") || order.isEmpty()))
            throw new InvalidOrderException();
    }
}
