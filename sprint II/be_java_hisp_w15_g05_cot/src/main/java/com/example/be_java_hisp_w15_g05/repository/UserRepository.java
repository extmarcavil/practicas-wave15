package com.example.be_java_hisp_w15_g05.repository;

import com.example.be_java_hisp_w15_g05.model.Post;
import com.example.be_java_hisp_w15_g05.model.Product;
import com.example.be_java_hisp_w15_g05.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Post> posts = new ArrayList<>();
    int postContador = 0;

    public UserRepository() {
        User galperin = new User(1, "Marcos Galperin", true);
        User antonio = new User(2, "Antonio", true);
        User juan = new User(10, "Juan", false);
        User pedro = new User(11, "APedro", false);
        User valentina = new User(12, "Valentina", false);

        galperin.agregarSeguidor(juan);
        juan.seguir(galperin);

        galperin.agregarSeguidor(pedro);
        pedro.seguir(galperin);

        antonio.agregarSeguidor(juan);
        juan.seguir(antonio);

        users.addAll(Arrays.asList(galperin, antonio, juan, pedro, valentina));

        Product p1 = new Product(0, "Mouse", "Tecnologia", "Raton", "Negro", "Bluetoo");
        Product p2 = new Product(1, "Teclado", "Tecnologia", "Teclado", "Blanco", "Bluetoo");

        Post posteo = new Post(1, 20, LocalDate.of(2022, 4, 1), p1, 100, 202.00);
        Post posteo2 = new Post(1, 21, LocalDate.now(), p2, 100, 202.00);
        Post posteo3 = new Post(1, 22, LocalDate.of(2022, 4, 24), p1, 100, 202.00);
        Post posteo4 = new Post(1, 23, LocalDate.of(2022, 4, 25), p2, 100, 202.00);

        posts.addAll(Arrays.asList(posteo, posteo2, posteo3, posteo4));
    }

    @Override
    public Optional<User> findById(int id) {
        return users.stream()
                .filter(u -> u.getUserId() == id)
                .findFirst();
    }

    @Override
    public void follow(User usuario, User vendedor) {
        vendedor.agregarSeguidor(usuario);
        usuario.seguir(vendedor);

    }

    @Override
    public void unFollow(User usuario, User vendedor) {
        vendedor.eliminarSeguidor(usuario);
        usuario.dejarDeSeguir(vendedor);
    }

    @Override
    public int cantFollowers(User user) {
        return user.getSeguidores().size();
    }

    @Override
    public void createPost(User user, Post post) {
        post.setPostId(postContador ++);
        posts.add(post);
        user.setSeller(true);
    }

    public List<Post> getPostsById(int id){

        return posts.stream()
                .filter(post -> post.getUserId() == id)
                .collect(Collectors.toList());
    }

}
