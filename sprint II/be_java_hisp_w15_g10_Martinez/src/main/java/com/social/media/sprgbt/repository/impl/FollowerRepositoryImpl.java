package com.social.media.sprgbt.repository.impl;

import com.social.media.sprgbt.entity.Follower;
import com.social.media.sprgbt.repository.IFollowerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class FollowerRepositoryImpl implements IFollowerRepository {

    public static AtomicInteger count = new AtomicInteger(0);

    /**
     * Lista de Usuarios.
     */
    public static List<Follower> listFollowers;

    /**
     * Constudtor por Default.
     */
    public FollowerRepositoryImpl() {
        this.listFollowers = new ArrayList<>();
    }


    /**
     * Create Follower
     *
     * @param follower
     * @return {@link Follower} obj
     */
    @Override
    public Follower createFollower(Follower follower) {

        follower.setId(count.incrementAndGet());
        log.info("Follower: {}", follower);

        listFollowers.add(follower);

        return follower;
    }

    /**
     * Get Follower By UserId And UserIdToFollow
     *
     * @param userId
     * @param userIdToFollow
     * @return {@link Follower} obj
     */
    @Override
    public Follower getFollowerByUserIdAndUserIdToFollow(Integer userId, Integer userIdToFollow) {

        Optional<Follower> followerOpt = listFollowers.stream()
                .filter(obj -> obj.getUserId().equals(userId) && obj.getUserIdToFollow().equals(userIdToFollow))
                .findFirst();

        return followerOpt.orElse(null);
    }

    /**
     * Get List All Followers.
     *
     * @return
     */
    @Override
    public List<Follower> getListAllFollowers() {
        return listFollowers;
    }

    /**
     * Get List Followers By Seller.
     *
     * @param userIdToFollow
     * @return
     */
    @Override
    public List<Follower> getListFollowersBySeller(Integer userIdToFollow) {

        List<Follower> listFollowersBySeller = listFollowers.stream()
                .filter(obj -> obj.getUserIdToFollow().equals(userIdToFollow))
                .collect(Collectors.toList());

        return listFollowersBySeller;
    }

    /**
     * Get List Followed By User.
     *
     * @param userId
     * @return
     */
    @Override
    public List<Follower> getListFollowedByUser(Integer userId) {

        List<Follower> listFollowedByUser = listFollowers.stream()
                .filter(obj -> obj.getUserId().equals(userId))
                .collect(Collectors.toList());

        return listFollowedByUser;
    }

    /**
     * Delete Follower.
     *
     * @param follower
     */
    @Override
    public void deleteFollower(Follower follower) {

        listFollowers.removeIf(objFollower ->
                objFollower.getId().equals(follower.getId()));

    }

}
