package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.exceptions.InvalidDateException;
import com.example.be_java_hisp_w15_g05.exceptions.InvalidPriceException;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotSellerException;
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

        User user = validateUserExists(post.getUserId());
        validateDate(post.getDate());
        validatePrice(post.getPrice());

        userRepository.createPost(user, post);

        return new ResCreatePostDTO("La publicación se ha creado con éxito");
    }

    public ResPostListDTO getPostFollowed(int userId, String order){
        User user = validateUserExists(userId);;

        List<Post> posts = new ArrayList<>();
        for(User usuario : user.getFollowed())
            posts.addAll(userRepository.getPostsTwoWeeks(usuario.getUserId()));

        sortListByDate(posts, order);

        List<PostIdDTO> lista = modelMapper.map(posts, new TypeToken<List<PostIdDTO>>() {}.getType());

        return new ResPostListDTO(userId,lista);
    }

    @Override
    public ResPromoPostsDTO getCountPromoPosts(int userId) {
        User user = validateUserExists(userId);;
        validateIsSeller(user);

        Integer countPromoPosts = userRepository.getPromoPosts(userId).size();

        return new ResPromoPostsDTO(user.getUserId(), user.getName(), countPromoPosts);
    }

    @Override
    public ResListPromoPostDTO getListPromoPosts(int userId) {
        User user = validateUserExists(userId);;
        validateIsSeller(user);

        List<Post> listPromoPosts = userRepository.getPromoPosts(userId);

        List<PromoPostDTO> listPromoPostsDTO = modelMapper.map(listPromoPosts, new TypeToken<List<PromoPostDTO>>() {}.getType());

        return new ResListPromoPostDTO(user.getUserId(), user.getName(), listPromoPostsDTO);
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

    private User validateUserExists(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userId + " no encontrado."));
    }

    private void validateIsSeller(User user) {
        if(!user.isSeller())
            throw new UserNotSellerException("El usuario " + user.getUserId() + " no es un vendedor");
    }

    private void sortListByDate(List<Post> list, String order) {
        if(order != null && order.equals("date_desc"))
            list.sort(Comparator.comparing(Post::getDate));
        else
            list.sort(Comparator.comparing(Post::getDate).reversed());
    }
}
