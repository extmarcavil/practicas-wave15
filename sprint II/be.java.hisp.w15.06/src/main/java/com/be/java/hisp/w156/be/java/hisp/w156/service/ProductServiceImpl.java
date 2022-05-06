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
        User user = useRepository.getUser(requestPostDto.getUser_id());
        Post postToSaved = Post.from(requestPostDto);
        user.getPosts().add(postToSaved);
        String message = String.format("Post with ID: %s was saved successfully", postToSaved.getPost_id());

        return new ResponseEntity<>(new SuccessDTO(message), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<RecentlyPostDTO> getPostsLastTwoWeekById(Integer id, String order) {

        validateDateOrdering(order);

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

    private void validateDateOrdering(String order) {
        if (!(order.equals("date_asc") || order.equals("date_desc") || order.isEmpty()))
            throw new InvalidOrderException();
    }
}
