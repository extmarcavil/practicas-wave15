package com.example.be_java_hisp_w15_g05.service;

import com.example.be_java_hisp_w15_g05.dto.PostDTO;
import com.example.be_java_hisp_w15_g05.dto.ResCreatePostDTO;
import com.example.be_java_hisp_w15_g05.exceptions.InvalidDateException;
import com.example.be_java_hisp_w15_g05.exceptions.InvalidPriceException;
import com.example.be_java_hisp_w15_g05.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w15_g05.model.Post;
import com.example.be_java_hisp_w15_g05.model.User;
import com.example.be_java_hisp_w15_g05.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

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

    private void validateDate(LocalDate date){
        Period period = Period.between(date, LocalDate.now());

        if(period.getDays() != 0 )
            throw new InvalidDateException("La fecha de la publicacion debe ser hoy.");
    }

    private void validatePrice (double price){
        if(price < 0)
            throw new InvalidPriceException("El precio del producto debe ser mayor a 0.");
    }
}
