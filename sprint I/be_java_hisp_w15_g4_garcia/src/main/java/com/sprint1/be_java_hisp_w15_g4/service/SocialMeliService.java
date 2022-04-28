package com.sprint1.be_java_hisp_w15_g4.service;

import com.sprint1.be_java_hisp_w15_g4.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.UserDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.request.PostWithPromoDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.*;
import com.sprint1.be_java_hisp_w15_g4.exception.AlreadyFollowing;
import com.sprint1.be_java_hisp_w15_g4.exception.IDNotFoundException;
import com.sprint1.be_java_hisp_w15_g4.exception.NotFollowException;
import com.sprint1.be_java_hisp_w15_g4.model.Post;
import com.sprint1.be_java_hisp_w15_g4.model.PostWithPromo;
import com.sprint1.be_java_hisp_w15_g4.model.Product;
import com.sprint1.be_java_hisp_w15_g4.model.User;
import com.sprint1.be_java_hisp_w15_g4.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;

import java.util.stream.Collectors;

@Service
public class SocialMeliService implements ISocialMeliService {
    IUserRepository repo;
    ModelMapper mapper = new ModelMapper();


    public SocialMeliService(IUserRepository repo) {
        this.repo = repo;
    }

    //Recibe dos id por parámetros y uno lo sigue al otro. En caso de que ya
    //se sigan, se lanza una excepción.
    @Override
    public void follow(int userID, int userIDToFollow) {
        User seguidor = getUser(userID);
        User seguido = getUser(userIDToFollow);
        if (!seguidor.getFollowing().contains(seguido) ){
            seguido.addFollower(seguidor);
            seguidor.addFollowing(seguido);
        }
        else throw new AlreadyFollowing(userID,userIDToFollow);
    }

    //Recibe un id por parámetro y devuelve la cantidad de seguidores que tiene.
    @Override
    public FollowerCountDTO countFollowers(int userID) {
        User user = getUser(userID);
        return new FollowerCountDTO(user.getUser_id(),user.getUser_name(),user.getFollowers().size());
    }

    //Recibe un id por parámetro y devuelve la cantidad de productos con
    //promoción que posteó.
    @Override
    public DiscountCountDTO countDiscountPost(int userID) {
        User user = getUser(userID);
        long discountProductsCount = 0;
        discountProductsCount = user.getPosts().stream()
                .filter(x -> x.isHas_promo())
                .count();
        return new DiscountCountDTO(user.getUser_id(), user.getUser_name(), discountProductsCount);
    }

    //Recibe un id y obtiene al usuario asociado a ese id.
    private User getUser(int userID) {
        User user = repo.findUser(userID);
        if (user == null)
            throw new IDNotFoundException(userID);
        return user;
    }

    //Recibe un id y una forma de ordenamiento (opcional). Devuelve la lista de seguidores ordenada por nombre
    //según la manera que reciba por parámetro. Si no recibe el orden lo realiza de manera ascendente.
    @Override
    public FollowerListDTO listFollowers(int userID,String order) {
        User user = getUser(userID);

        FollowerListDTO retorno= new FollowerListDTO(user.getUser_id(),user.getUser_name(),
                user.getFollowers().stream()
                        .map(user1 -> new UserDTO(user1.getUser_id(),user1.getUser_name()))
                        .collect(Collectors.toList())
        );
        orderByName(order, retorno.getFollowers());
        return retorno;
    }

    //Recibe un id y una forma de ordenamiento (opcional). Devuelve la lista de seguidos ordenada por nombre
    //según la manera que reciba por parámetro. Si no recibe el orden lo realiza de manera ascendente.
    @Override
    public FollowingListDTO listFollowing(int userID, String order) {
        FollowingListDTO followingsDTO = new FollowingListDTO();
        List<UserDTO> userDTO = new ArrayList<>();

        User user = getUser(userID);

        followingsDTO.setUser_id(user.getUser_id());
        followingsDTO.setUser_name(user.getUser_name());


        for (User u : user.getFollowing()) {
            userDTO.add(new UserDTO(u.getUser_id(), u.getUser_name()));
        }

        orderByName(order, userDTO);

        followingsDTO.setFollowed(userDTO);

        return followingsDTO;
    }

    //Recibe un postDTO por parametro y lo agrega a los post del usuario.
    @Override
    public void createPost(PostDTO post) {
        User user = getUser(post.getUser_id());
        user.addPost(mapper.map(post, Post.class));
    }

    //Recibe un post con promoción por parámetro y lo agrega a los post del usuario.
    @Override
    public void createPostWithPromo(PostWithPromoDTO promo){
        User user = getUser(promo.getUser_id());
        user.addPost(mapper.map(promo, PostWithPromo.class));
    }

    //Recibe un id por parámetro y devuelve la lista con los productos en promoción.
    public DiscountListDTO listDiscountProducts(int userID){
        User user = getUser(userID);
        DiscountListDTO discountsList = new DiscountListDTO(user.getUser_id(), user.getUser_name(), user.getPosts().stream()
                .filter(x -> x.isHas_promo())
                .map(promo -> mapper.map(promo, PostWithPromoDTO.class))
                .collect(Collectors.toList()));
        return discountsList;
    }

    //Recibe un id por parámetro y un orden. Devuelve los post de las últimas dos semanas de ese usuario
    //ordenado por fecha en el orden recibido por parámetro.
    @Override
    public PostListDTO lastTwoWeeksPosts(int userID, String order) {
        List<User> vendedoresSeguidos = repo.findUser(userID).getFollowing();

        List<Post> posts = vendedoresSeguidos.stream()
                .flatMap(v -> v.getPosts().stream())
                .filter(Post :: ultimas2Semanas)
                .collect(Collectors.toList());

        List<Post> ordenado = orderByDate(posts, order);

        List<PostDTO> lastPostsDTO = ordenado.stream()
                .map(m -> mapper.map(m, PostDTO.class))
                .collect(Collectors.toList());

        return new PostListDTO(userID, lastPostsDTO);
    }

    //Ordena por nombre según el orden recibido.
    private void orderByName(String order, List<UserDTO> userDTO) {
        if (order == null || order.equals("name_asc")) {
            userDTO.sort(Comparator.comparing(UserDTO::getUser_name));
        } else if (order.equals("name_desc")) {
            userDTO.sort( (u1, u2) -> u2.getUser_name().compareTo(u1.getUser_name()));
        }
    }

    //Ordena por fecha según el orden recibido
    private List<Post> orderByDate(List<Post> posts, String order) {
        if (order == null || order.equals("date_desc"))
            return posts.stream().sorted(Comparator.comparing(Post::getDate)).collect(Collectors.toList());

        return posts.stream().sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
    }

    @Override
    public void unfollow(int userID, int userIDToUnfollow) {
        User user = getUser(userID);
        User userToUnfollow = getUser(userIDToUnfollow);
        if(!user.getFollowing().contains(userToUnfollow)){
            throw new NotFollowException(userIDToUnfollow);
        }
        user.removeFollowing(userToUnfollow);
        userToUnfollow.removeFollower(user);
    }

}
