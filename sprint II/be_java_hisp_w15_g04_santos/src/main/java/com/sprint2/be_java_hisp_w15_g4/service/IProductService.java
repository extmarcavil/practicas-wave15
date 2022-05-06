package com.sprint2.be_java_hisp_w15_g4.service;

import com.sprint2.be_java_hisp_w15_g4.dto.request.PostDTO;
import com.sprint2.be_java_hisp_w15_g4.dto.response.PostListDTO;

public interface IProductService {
    void createPost(PostDTO post); //Req 05: le llega una publicaciondto y devuelve un OK
    PostListDTO lastTwoWeeksPosts(int userID, String order); //Req 06: Devuelve una lista con los post de las últimas dos semanas de los seguidos de un usuario.
}
