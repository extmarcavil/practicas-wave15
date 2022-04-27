package com.be.java.hisp.w156.be.java.hisp.w156.repository;

import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class PostRepositoryImpl implements IPostRepository {

    private List<Post>postList;

    public PostRepositoryImpl(){
        postList = new ArrayList<>();
    }

    @PostConstruct
    public void loadData() {
        postList = Stream.of(
                new Post(1, LocalDate.of(2022, 4, 26), null, "100", 500.50),
                new Post(1, LocalDate.of(2022, 4, 12), null, "100", 600.50))
                .collect(Collectors.toList());
    }

    public void save(Post post){
        postList.add(post);

    }
}
