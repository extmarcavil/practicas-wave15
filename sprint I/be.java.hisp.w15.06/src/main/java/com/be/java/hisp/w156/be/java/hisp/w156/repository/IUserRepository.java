package com.be.java.hisp.w156.be.java.hisp.w156.repository;

import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.User;

import java.util.List;

public interface IUserRepository {

    void initData();

    User getUser(Integer id);

    void follow(Integer userId, Integer userIdToFollow);

    void unfollow(Integer userId, Integer userIdToUnfollow);

    Integer getCountFollow(Integer id);

    List<User> getFollowers(Integer id);

    List<User> getFollowed(Integer id);

    void savePost(Post post);

    List<Post> getPostsLastTwoWeekById(Integer id);

}
