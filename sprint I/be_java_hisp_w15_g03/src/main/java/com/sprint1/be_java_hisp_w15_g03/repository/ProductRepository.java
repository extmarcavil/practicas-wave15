package com.sprint1.be_java_hisp_w15_g03.repository;

import com.sprint1.be_java_hisp_w15_g03.model.Publication;

public interface ProductRepository {
    boolean userExist(Integer userId);

    void savePublication(Integer userId, Publication p);

}
