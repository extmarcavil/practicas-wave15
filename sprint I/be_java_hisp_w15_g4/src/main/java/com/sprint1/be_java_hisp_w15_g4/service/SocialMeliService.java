package com.sprint1.be_java_hisp_w15_g4.service;

import com.sprint1.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowerListDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.FollowingListDTO;
import com.sprint1.be_java_hisp_w15_g4.dto.response.PostListDTO;
import com.sprint1.be_java_hisp_w15_g4.exception.IDNotFoundException;
import com.sprint1.be_java_hisp_w15_g4.model.User;
import com.sprint1.be_java_hisp_w15_g4.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class SocialMeliService implements ISocialMeliService {
    IUserRepository repo;


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
        return null;
    }

    @Override
    public void unfollow(int userID, int userIDToUnfollow) {

    }
    //    void orderByAlphabet(/* PostListDTO listaDelReq06*/); //Req 08: ordena alfabeticamente de manera ascendente y descendente a los post del Req 06
    //    void orderByDate(/* PostListDTO listaDelReq06*/); //Req 09: ordena ascendente y descendentemente por fecha a los post del Req 06
}
