package com.sprint.be_java_hisp_w15_g10.utils;

import com.sprint.be_java_hisp_w15_g10.Model.Category;
import com.sprint.be_java_hisp_w15_g10.Model.Post;
import com.sprint.be_java_hisp_w15_g10.Model.Product;
import com.sprint.be_java_hisp_w15_g10.Model.User;
import com.sprint.be_java_hisp_w15_g10.Repository.CategoryRepository;
import com.sprint.be_java_hisp_w15_g10.Repository.PostRepository;
import com.sprint.be_java_hisp_w15_g10.Repository.ProductRepository;
import com.sprint.be_java_hisp_w15_g10.Repository.UserRepository;

import java.time.LocalDate;

public class TestUtils {

    public static Category createCategory(){
        return new Category(4, "Tecnología");
    }

    public static Product createProduct(){
        return new Product(6, "Mouse", "Gamer", "Huawei", "Negro","últimos productos");

    }

    public static Post createPost(PostRepository postRepository, LocalDate date){
        return new Post(postRepository.nextIndex(),
                new Product(6, "Mouse", "Gamer", "Huawei", "Negro","últimos productos"),
                date,
                new Category(4, "Tecnología"),
                2.10,
                true,
                0.5);
    }

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
