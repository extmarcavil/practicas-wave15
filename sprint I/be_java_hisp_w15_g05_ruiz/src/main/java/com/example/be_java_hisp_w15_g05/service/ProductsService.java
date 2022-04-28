package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.*;
import com.example.be_java_hisp_w15_g05.exceptions.InvalidDateException;
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
import java.util.Optional;


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
    public ResCreatePostDTO createPostPromotion(PostPromotionDTO postPromotionDTO) {
        Post postPromotion = modelMapper.map(postPromotionDTO, Post.class);

        User user = userRepository.findById(postPromotion.getUserId())
                .orElseThrow(() -> new UserNotFoundException("Usuario " + postPromotion.getUserId() + " no encontrado."));


        validatePrice(postPromotion.getPrice());
        validateDiscount(postPromotion.getDiscount());
        userRepository.createPost(user, postPromotion);

        return new ResCreatePostDTO("La publicación del producto en promoción se ha creado con éxito");
    }

    public ResPostListDTO getPostFollowed(int id, String order){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + id + " no encontrado."));

        List<Post> listadoPosteos = new ArrayList<>();

        for( User usuario : user.getSeguidos()){
            listadoPosteos.addAll(userRepository.getPostsTwoWeeks(usuario.getUserId()));
        }

        if( order!=null && order.equals("date_desc")){
            listadoPosteos.sort(Comparator.comparing(Post::getDate));
        }else{
            listadoPosteos.sort(Comparator.comparing(Post::getDate).reversed());
        }

        List<PostIdDTO> lista = modelMapper.map(listadoPosteos,new TypeToken<List<PostIdDTO>>() {}.getType());

        return new ResPostListDTO(id,lista);
    }

    @Override
    public ResListPostPromoDTO listProductsPromo(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userId + " no encontrado."));
        List<Post> listPostProm= userRepository.getListProductsPromo(userId);

        return new ResListPostPromoDTO(user.getUserId(),user.getName(),listPostProm);
    }

    @Override
    public ResCountProductsPromoDTO countProductsPromo(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + userId + " no encontrado."));

        int cantProductsProm = userRepository.cantProductPromo(userId);
        return new ResCountProductsPromoDTO(user.getUserId(),user.getName(),cantProductsProm);
    }



    private void validateDate(LocalDate date){
        long period = ChronoUnit.DAYS.between( date , LocalDate.now());
        System.out.println("la fecha ingresada es:");
        if(period > 1 )
            throw new InvalidDateException("La fecha de la publicacion debe ser a partir de hoy."+" fecha ingresada: "+date +" hoy es:"+LocalDate.now());
    }

    private void validatePrice (double price){
        if(price < 0)
            throw new InvalidPriceException("El precio del producto debe ser mayor a 0.");
    }
    private void validateDiscount (double desc){
        if(desc < 0)
            throw new InvalidPriceException("el descuento debe ser mayor a cero");
    }

}
