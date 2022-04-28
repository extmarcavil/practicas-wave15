package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.ResponsePostDTO;
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
import org.springframework.ui.ModelMap;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    private final IUserRepository useRepository;
    ModelMap mapper;

    @Autowired
    public ProductServiceImpl(IUserRepository useRepository, ModelMap mapper) {
        this.useRepository = useRepository;
        this.mapper = new ModelMap() ;
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

    /**
     * @param : RequestPostDTO
     * @return: ResponseEntity<SuccessDTO>
     *
     * Esta función sirve para guardar los Post en promocion
     * Deberia mappear RequestPromoDTO a PromoPostDTO
     * Preguntar si el user es valido
     *
     * Tomar el usuario y guardar el post
     * */
    @Override
    public ResponseEntity<SuccessDTO> savePromoPost(RequestPromoPostDTO requestPromoPostDTO, ModelMap mapper) {

        PromoPost promoPost = requestPromoPostDTO.mapper.map(RequestPromoPostDTO.class); // Revisar con Marco?
        User user = useRepository.getUser(requestPromoPostDTO.getId_usuario());
        user.getPromoPostList().add(promoPost) ; // Chequear con Marco

            String message = String.format("New promotional post with ID: %s  has been created successfully", promoPost.getId());
            return new ResponseEntity<>(new SuccessDTO(message), HttpStatus.CREATED);
        }
        throw new UserNotFoundException( //Pendiente esto  );
    }
}
