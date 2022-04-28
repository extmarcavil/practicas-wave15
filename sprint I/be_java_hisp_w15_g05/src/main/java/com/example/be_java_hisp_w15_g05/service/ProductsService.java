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



        List<PostIdDTO> lista = modelMapper.map(listadoPosteos, new TypeToken<List<PostIdDTO>>() {}.getType());

        return new ResPostListDTO(id,lista);
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
}
