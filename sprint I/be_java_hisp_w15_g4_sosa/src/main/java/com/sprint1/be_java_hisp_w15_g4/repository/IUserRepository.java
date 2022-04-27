package com.sprint1.be_java_hisp_w15_g4.repository;

import com.sprint1.be_java_hisp_w15_g4.dto.response.PostPromoListDTO;
import com.sprint1.be_java_hisp_w15_g4.model.PostPromo;
import com.sprint1.be_java_hisp_w15_g4.model.User;

import java.util.List;

public interface IUserRepository {
    User findUser(int id);
    List<PostPromo> getAllPromos();
}
