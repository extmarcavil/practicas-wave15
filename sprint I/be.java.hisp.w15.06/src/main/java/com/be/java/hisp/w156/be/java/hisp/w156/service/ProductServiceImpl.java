package com.be.java.hisp.w156.be.java.hisp.w156.service;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.RecentlyPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.ResponsePostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.PromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponseListPromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ResponsePromoPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.SuccessDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.NotPromoPostException;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.OrderNotFoundException;
import com.be.java.hisp.w156.be.java.hisp.w156.exception.UserNotFoundException;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.be.java.hisp.w156.be.java.hisp.w156.model.PromoPost;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;
import com.be.java.hisp.w156.be.java.hisp.w156.repository.IUserRepository;
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

    private final IUserRepository useRepository;
    ModelMapper mapper;

    @Autowired
    public ProductServiceImpl(IUserRepository useRepository) {
        this.useRepository = useRepository;
        this.mapper = new ModelMapper();
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

        if (order.equals("date_asc"))
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
     * @param : RequestPromoPostDTO, ModelMapper
     * @return: ResponseEntity<SuccessDTO>
     * <p>
     * Esta función sirve para guardar los Post que estén en promoción en promocion
     **/
    @Override
    public ResponseEntity<SuccessDTO> savePromoPost(RequestPromoPostDTO requestPromoPostDTO) {
        if (useRepository.getUser(requestPromoPostDTO.getUser_id()) == null) {
            throw new UserNotFoundException(requestPromoPostDTO.getUser_id());
        }
        if (requestPromoPostDTO.isHas_promo() == false) {
            throw new NotPromoPostException();
        }
        PromoPost promoPost = mapper.map(requestPromoPostDTO, PromoPost.class);
        User user = useRepository.getUser(requestPromoPostDTO.getUser_id());
        promoPost.setPost_id(requestPromoPostDTO.getUser_id());
        user.getPromoPostList().add(promoPost); //improve code..
        String message = String.format("New promotional post with ID: %s  has been created successfully", promoPost.getPost_id());
        return new ResponseEntity<>(new SuccessDTO(message), HttpStatus.CREATED);
    }


    /**
     * @param: Integer user_id
     * @return: RequestPromoPostDTO
     * Obtener la cantidad de productos en promoción de un determinado vendedor
     */
    public ResponsePromoPostDTO getCountPromoPostByUser(Integer user_id) {

        if (!useRepository.existsById(user_id)) {
            throw new UserNotFoundException(user_id);
        }

        User user = useRepository.getUser(user_id); // me conviene guardarlo asi?
        ResponsePromoPostDTO responsePromoPostDTO = new ResponsePromoPostDTO(user.getId(), user.getName(), user.getPromoPostList().size());
        return responsePromoPostDTO;

    }

    /**
     * @param : Integer user_id, String order
     * @return : ResponseListPromoPostDTO
     *
     * Obtener un listado de todos los productos en promoción de un determinado vendedor
     */
    public ResponseListPromoPostDTO getPromoPostByUser(Integer user_id, String order) {
        if(order != null && !order.equalsIgnoreCase("producName_asc") &&  !order.equalsIgnoreCase("producName_desc")  ){
            throw new OrderNotFoundException(order);
        }

        if (!useRepository.existsById(user_id)) {
            throw new UserNotFoundException(user_id);
        }
        User user = useRepository.getUser(user_id);

        Comparator<PromoPost> orderByProductName = null;
        if (order.equals("producName_asc")) {
            orderByProductName = Comparator.comparing(PromoPost::getProductName);
        } else if (order.equals("producName_desc")) {
            orderByProductName = Comparator.comparing(PromoPost::getProductName).reversed();
        }

        List<PromoPostDTO> mapList = user.getPromoPostList()
                .stream()
                .sorted(orderByProductName)
                .map(promoPost -> mapper.map(promoPost, PromoPostDTO.class))
                .collect(Collectors.toList());


        ResponseListPromoPostDTO responseListPromoPostDTO = new ResponseListPromoPostDTO(user.getId(), user.getName(), mapList);
        return responseListPromoPostDTO;

    }

}


