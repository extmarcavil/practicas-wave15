package ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.repository;

import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.Follow;
import ar.com.mercadolibre.bootcamp.be_java_hisp_w15_g01.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public List<Follow> whoFollows(Long id) {
        return follows
                .stream()
                .filter(f -> f.getFollowing().getUserId().equals(id))
                .collect(Collectors.toList());

    }

    @Override
    public List<User> findFollowedByUserId(Long id) {
       List<User> followed = follows.stream()
               .filter(x->x.getFollower().getUserId().equals(id))
               .map(a->a.getFollowing())
               .collect(Collectors.toList());

       return followed;
    }
}
