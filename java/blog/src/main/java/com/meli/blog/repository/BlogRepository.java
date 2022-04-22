package com.meli.blog.repository;

import com.meli.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class BlogRepository extends AbstractRepository<Blog, Long> {

    @Override
    public List<Blog> initData() {
        return Stream.of(
                new Blog(1L, "Aprendiendo a programar", "Pepe", LocalDate.now()),
                new Blog(2L, "Aprendiendo a programar 2", "Pepe", LocalDate.now()),
                new Blog(3L, "Aprendiendo a cocinar", "Arturo", LocalDate.now()),
                new Blog(4L, "Aprendiendo a hacer otra cosa", "Elmo", LocalDate.now()),
                new Blog(5L, "Aprendiendo a jugar", "Vivido", LocalDate.now())
        ).collect(Collectors.toList());
    }

    @Override
    public void save(Blog blog) {
        repository.add(blog);
    }

    @Override
    public void update(Blog blog) {

    }

    @Override
    public List<Blog> findAll() {
        return repository;
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return repository.stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean exists(Blog blog) {
        return repository.contains(blog);
    }

    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

}
