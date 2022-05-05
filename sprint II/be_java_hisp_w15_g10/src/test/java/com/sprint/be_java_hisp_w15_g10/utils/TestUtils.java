package com.sprint.be_java_hisp_w15_g10.utils;

import com.sprint.be_java_hisp_w15_g10.Model.Category;
import com.sprint.be_java_hisp_w15_g10.Model.Post;
import com.sprint.be_java_hisp_w15_g10.Model.Product;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Repository.UserRepository;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {
    public static User createFollowedUser(UserRepository userRepository){
        User user1 = new User(4,"Luis");
        User user2 = new User(5,"David");
        User user3 = new User(6,"Alfredo");
        User user4 = new User(7,"Raúl");
        user1.agregarSeguidor(user2);
        user1.agregarSeguidor(user3);
        user1.agregarSeguidor(user4);
        user2.seguirUsuario(user1);
        user3.seguirUsuario(user1);
        user4.seguirUsuario(user1);
        userRepository.add(user1);
        userRepository.add(user2);
        userRepository.add(user3);
        userRepository.add(user4);
        return user1;
    }

    public static User createUser(int i, String name){
        return new User(i, name);
    }

    public static void followUser(User cliente, User vendedor){
        cliente.seguirUsuario(vendedor);
        vendedor.agregarSeguidor(cliente);
    }

    public static void addFollowers(User user, int id){
        User user1 = createUser(id+1, "David");
        User user2 = createUser(id+2, "Jorge");
        User user3 = createUser(id+3, "Jesus");
        User user4 = createUser(id+4, "Daniel");
        User user5 = createUser(id+5, "Alfredo");
        followUser(user1, user);
        followUser(user2, user);
        followUser(user3, user);
        followUser(user4, user);
        followUser(user5, user);
    }

    public static List<Post> addFollowedPosts(User user){

        List<User> followed = user.getFollowed();

        Category category1 = new Category(1, "Primera categoria");
        Category category2 = new Category(1, "Segunda categoria");

        Product product1 = new Product(1, "Pantalón", "Old", "Jeff", "Rojo", "");
        Product product2 = new Product(2, "Falda", "Teen", "Punto", "Negra", "Forma lápiz");

        LocalDate oneMonthAgo = LocalDate.now().minusWeeks(4);
        LocalDate oneWeekAgo = LocalDate.now().minusWeeks(1);
        LocalDate yesterday = LocalDate.now().minusDays(1);

        Post post1 = new Post(1, product1, oneMonthAgo, category1, 0.9, false, 0);
        Post post2 = new Post(2, product2, oneWeekAgo, category1, 1.2, true, 0.9);
        Post post3 = new Post(3, product1, yesterday, category2, 3.4, false, 0);

        followed.get(0).agregarPost(post1);
        followed.get(1).agregarPost(post2);
        followed.get(2).agregarPost(post3);

        List<Post> validPosts = new ArrayList<>();
        validPosts.add(post3);
        validPosts.add(post2);

        return validPosts;
    }

    public static void addFollowed(User user, int id){
        User user1 = createUser(id+1, "David");
        User user2 = createUser(id+2, "Jorge");
        User user3 = createUser(id+3, "Jesus");
        User user4 = createUser(id+4, "Daniel");
        User user5 = createUser(id+5, "Alfredo");
        followUser(user, user1);
        followUser(user, user2);
        followUser(user, user3);
        followUser(user, user4);
        followUser(user, user5);
    }
}
