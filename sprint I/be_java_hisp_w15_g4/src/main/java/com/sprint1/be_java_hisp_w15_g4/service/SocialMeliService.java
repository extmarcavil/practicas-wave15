package com.sprint1.be_java_hisp_w15_g4.service;

import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerListDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowingListDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.PostListDTO;
import com.sprint1.be_java_hisp_w15_g4.exception.IDNotFoundException;
import com.sprint1.be_java_hisp_w15_g4.model.Post;
import com.sprint1.be_java_hisp_w15_g4.model.User;
import com.sprint1.be_java_hisp_w15_g4.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialMeliService implements ISocialMeliService {
    IUserRepository repo;
    ModelMapper mapper = new ModelMapper();


    public SocialMeliService(IUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public void follow(int userID, int userIDToFollow) {
        User seguidor = repo.findUser(userID);
        User seguido = repo.findUser(userIDToFollow);
        if (seguido == null || seguidor == null)
            throw new IDNotFoundException("No se encontro el ID del usuario solicitado.");
        seguido.addFollower(seguidor);
        seguidor.addFollowing(seguido);

    }

    @Override
    public FollowerCountDTO countFollowers(int userID) {
        return null;
    }

    @Override
    public FollowerListDTO listFollowers(int userID) {
        return null;
    }

    @Override
    public FollowingListDTO listFollowing(int userID) {
        return null;
    }

    @Override
    public void createPost(PostDTO post) {

    }

    @Override
    public PostListDTO lastTwoWeeksPosts(int userID) {
        List<User> vendedoresSeguidos = repo.findUser(userID).getFollowing();

        List<Post> posts = vendedoresSeguidos.stream()
                .flatMap(v -> v.getPosts().stream())
                .filter(p -> p.ultimas2Semanas())
                .collect(Collectors.toList());

        List<Post> ordenado = orderByDate(posts);

        List<PostDTO> lastPostsDTO = posts.stream()
                .map(m -> mapper.map(m, PostDTO.class))
                .collect(Collectors.toList());

        return new PostListDTO(userID, lastPostsDTO);
    }

    private List<Post> orderByDate(List<Post> posts) {
        return posts; //posts.sort(Comparator.comparing(Post::getDate));
    }

    @Override
    public void unfollow(int userID, int userIDToUnfollow) {

    }
    //    void orderByAlphabet(/* PostListDTO listaDelReq06*/); //Req 08: ordena alfabeticamente de manera ascendente y descendente a los post del Req 06
    //    void orderByDate(/* PostListDTO listaDelReq06*/); //Req 09: ordena ascendente y descendentemente por fecha a los post del Req 06
}
