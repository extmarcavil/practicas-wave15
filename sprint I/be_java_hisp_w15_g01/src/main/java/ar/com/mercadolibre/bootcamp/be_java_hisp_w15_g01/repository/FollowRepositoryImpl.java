package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Follow;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FollowRepositoryImpl implements FollowRepository {
    private final List<Follow> follows;

    public FollowRepositoryImpl() {
        this.follows = new ArrayList<>();
    }

    @Override
    public Follow save(User follower, User following) {
        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowing(following);
        follows.add(follow);
        return follow;
    }
}
