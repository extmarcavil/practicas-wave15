package com.be.java.hisp.w156.be.java.hisp.w156.repository;

import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;

import java.io.Serializable;

public interface IPostRepository extends Serializable {

    void loadData();
    void save(Post post);
}
