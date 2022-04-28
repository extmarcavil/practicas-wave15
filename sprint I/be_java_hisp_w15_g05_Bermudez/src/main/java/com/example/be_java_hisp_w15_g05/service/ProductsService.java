package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.dto.response.ResCountPromoPostDTO;
import com.example.be_java_hisp_w15_g05.dto.response.ResCreatePostDTO;
import com.example.be_java_hisp_w15_g05.dto.response.ResListPromoPostDTO;
import com.example.be_java_hisp_w15_g05.dto.response.ResPostListDTO;
import com.example.be_java_hisp_w15_g05.exceptions.InvalidDateException;
import com.example.be_java_hisp_w15_g05.exceptions.InvalidDiscountException;
import com.example.be_java_hisp_w15_g05.exceptions.InvalidPriceException;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w15_g05.model.Post;
import com.example.be_java_hisp_w15_g05.model.User;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
public class ProductsService implements IProductsService {

    private ModelMapper modelMapper;
    private IUserRepository userRepository;

    public ProductsService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public ResCreatePostDTO createPost(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);

        User user = userRepository.findById(post.getUserId())
                .orElseThrow(() -> new UserNotFoundException("Usuario " + post.getUserId() + " no encontrado."));

        validateDate(post.getDate());
        validatePrice(post.getPrice());

        userRepository.createPost(user, post);

        return new ResCreatePostDTO("La publicación se ha creado con éxito");
    }

    @Override
    public ResCreatePostDTO createPromoPost(PromoPostDTO promoPostDTO) {
        Post post = modelMapper.map(promoPostDTO, Post.class);

        User user = userRepository.findById(post.getUserId())
                .orElseThrow(() -> new UserNotFoundException("Usuario " + post.getUserId() + " no encontrado."));

        validateDate(post.getDate());
        validatePrice(post.getPrice());
        validatePromoPost(post.isHasPromo());
        validateDiscount(post.getDiscount());

        userRepository.createPost(user, post);
        return new ResCreatePostDTO("La publicacion se ha creado con éxito.");
    }

    @Override
    public ResPostListDTO getPostFollowed(int id, String order){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + id + " no encontrado."));

        List<Post> listedPosts = new ArrayList<>();

        for( User u : user.getSeguidos()){
            listedPosts.addAll(userRepository.getPostsTwoWeeks(u.getUserId()));
        }

        if( order!=null && order.equals("date_desc")){
            listedPosts.sort(Comparator.comparing(Post::getDate));
        }else{
            listedPosts.sort(Comparator.comparing(Post::getDate).reversed());
        }



        List<PostIdDTO> list = modelMapper.map(listedPosts,new TypeToken<List<PostIdDTO>>() {}.getType());

        return new ResPostListDTO(id,list);
    }

    @Override
    public ResCountPromoPostDTO getCountPromoPosts(int userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userId + " no encontrado."));

        int qPromoPost = userRepository.qPromoPosts(user);

        return new ResCountPromoPostDTO(userId,user.getName(),qPromoPost);
    }

    @Override
    public ResListPromoPostDTO getListPromoPosts(int userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userId + " no encontrado."));

        List<PromoPostIdDTO> promo_list = new ArrayList<>();

        for( Post post : user.getPublicaciones())
            if(post.isHasPromo()){
                PromoPostIdDTO promo_post = modelMapper.map(post,PromoPostIdDTO.class);
                promo_list.add(promo_post);
            }

        return new ResListPromoPostDTO(userId,user.getName(),promo_list);
    }


    private void validateDate(LocalDate date){
        long period = ChronoUnit.DAYS.between( date , LocalDate.now());

        if(period > 1 )
            throw new InvalidDateException("La fecha de la publicacion debe ser a partir de hoy.");
    }

    private void validatePrice (double price){
        if(price < 0)
            throw new InvalidPriceException("El precio del producto debe ser mayor a 0.");
    }

    private void validateDiscount (double discount){
        if(discount <= 0)
            throw new InvalidDiscountException("El descuento de la publicacion debe ser mayor a 0.");
    }

    private void validatePromoPost (boolean flag){
        if(!flag)
            throw new InvalidDiscountException("Para crear una publicacion con promocion, se debe chequear el casillero como verdadero.");
    }
}
