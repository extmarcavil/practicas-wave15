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
import java.util.stream.Collectors;


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

        User user = userRepository.findById(post.getUser_id())
                .orElseThrow(() -> new UserNotFoundException("Usuario " + post.getUser_id() + " no encontrado."));

        validateDate(post.getDate());
        validatePrice(post.getPrice());

        userRepository.createPost(user, post);

        return new ResCreatePostDTO("La publicación se ha creado con éxito");
    }

    @Override
    public ResCreatePostDTO createPromoPost(PostPromoDTO postPromoDTO) {
        Post post = modelMapper.map(postPromoDTO, Post.class);

        User user = userRepository.findById(post.getUser_id())
                .orElseThrow(() -> new UserNotFoundException("Usuario " + post.getUser_id() + " no encontrado."));

        validateDate(post.getDate());
        validatePrice(post.getPrice());

        userRepository.createPost(user, post);

        return new ResCreatePostDTO("Publicacion con promo realizada con éxito");
    }

    public ResPostListDTO getPostFollowed(int id, String order) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + id + " no encontrado."));

        List<Post> listadoPosteos = new ArrayList<>();

        for (User usuario : user.getSeguidos()) {
            listadoPosteos.addAll(userRepository.getPostsTwoWeeks(usuario.getUserId()));
        }

        if (order != null && order.equals("date_desc")) {
            listadoPosteos.sort(Comparator.comparing(Post::getDate));
        } else {
            listadoPosteos.sort(Comparator.comparing(Post::getDate).reversed());
        }


        List<PostIdDTO> lista = modelMapper.map(listadoPosteos, new TypeToken<List<PostIdDTO>>() {
        }.getType());

        return new ResPostListDTO(id, lista);
    }

    @Override
    public ResPostPromoCountDTO getPostPromoCount(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + id + " no encontrado."));

        List<Post> listadoPosteos = userRepository.getPostsTwoWeeks(user.getUserId());

        //filtro los posteos del seller que sean de promo
        //el count me devuelve un long por eso lo casteo a int
        return new ResPostPromoCountDTO(
                id,
                user.getName(),
                (int) listadoPosteos.stream().filter(p -> p.isHas_promo()).count());
    }

    @Override
    public ResPostPromoListDTO getPostPromoList(int id, String order) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + id + " no encontrado."));

        List<Post> listadoPosteos = userRepository.getPostsTwoWeeks(user.getUserId());
        listadoPosteos = listadoPosteos.stream().filter(p -> p.isHas_promo()).collect(Collectors.toList());
        List<PostFullDTO> lista = modelMapper.map(listadoPosteos, new TypeToken<List<PostFullDTO>>() {
        }.getType());

        // No utilizo la version compactada para poder usar el ignorecase
        orderList(order, lista);

        return new ResPostPromoListDTO(id, user.getName(), lista);
    }

    @Override
    public ResPostPromoListDTO getAllPost(int id, String order) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario " + id + " no encontrado."));

        List<Post> postList = userRepository.getAllPost(id);

        List<PostFullDTO> dtoList = modelMapper.map(postList, new TypeToken<List<PostFullDTO>>() {
        }.getType());

        // No utilizo la version compactada para poder usar el ignorecase
        orderList(order, dtoList);

        return new ResPostPromoListDTO(id, user.getName(), dtoList);
    }

    private void orderList(String order, List<PostFullDTO> dtoList) {
        if (order.equals("name_desc")) {
            dtoList.sort((p1, p2) -> p2.getDetail().getProductName().compareToIgnoreCase(p1.getDetail().getProductName()));
        } else {
            dtoList.sort((p1, p2) -> p1.getDetail().getProductName().compareToIgnoreCase(p2.getDetail().getProductName()));
        }
    }


    private void validateDate(LocalDate date) {
        long period = ChronoUnit.DAYS.between(date, LocalDate.now());

        if (period > 1)
            throw new InvalidDateException("La fecha de la publicacion debe ser a partir de hoy.");
    }

    private void validatePrice(double price) {
        if (price < 0)
            throw new InvalidPriceException("El precio del producto debe ser mayor a 0.");
    }
}
