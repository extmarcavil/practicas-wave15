package com.example.be_java_hisp_w15_g05.repository;

import com.example.be_java_hisp_w15_g05.model.Post;
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

        users.add(galperin);
        users.add(antonio);
        users.add(juan);
        users.add(pedro);
        users.add(valentina);

        Post posteo = new Post(1,20,LocalDate.of(2022,4,1),null,100,202.00);
        Post posteo2 = new Post(1,21,LocalDate.of(2022,4,26),null,100,202.00);
        Post posteo3 = new Post(1,22,LocalDate.of(2022,4,24),null,100,202.00);
        Post posteo4 = new Post(1,23,LocalDate.of(2022,4,25),null,100,202.00);

        posts.addAll(Arrays.asList(posteo,posteo2,posteo3,posteo4));
    }

    @Override
    public Optional<User> findById(int id) {
        return users.stream()
                .filter(u -> u.getUserId() == id)
                .findFirst();
    }

    @Override
    public boolean follow(User usuario, User vendedor) {
        if(vendedor.isSeller()){
            vendedor.agregarSeguidor(usuario);
            usuario.seguir(vendedor);
            return true;
        }
        return false;
    }

    @Override
    public boolean unFollow(User usuario, User vendedor) {
        if(vendedor.isSeller() && vendedor.getSeguidores().contains(usuario)){
            vendedor.eliminarSeguidor(usuario);
            usuario.dejarDeSeguir(vendedor);
            return true;
        }
        return false;
    }

    @Override
    public int cantFollowers(User user) {
        return user.getSeguidores().size();
    }

    @Override
    public Optional<User> followersList(int id) {
        return findById(id);
    }

    @Override
    public void createPost(User user, Post post) {
        post.setPostId(postContador ++);
        posts.add(post);
        user.setSeller(true);
    }

    public List<Post> getPostsTwoWeeks(int id){

        return posts.stream()
                .filter(post -> post.getUserId() == id && inTwoWeeksRange(post.getDate()))
                .collect(Collectors.toList());
    }


    public Optional<User> sellersList(int id) {
        return findById(id);
    }

    private boolean inTwoWeeksRange(LocalDate fecha){

        long differencesInDays = ChronoUnit.DAYS.between( fecha , LocalDate.now() );

        return differencesInDays < 14 && differencesInDays >= 0;
    }

}
