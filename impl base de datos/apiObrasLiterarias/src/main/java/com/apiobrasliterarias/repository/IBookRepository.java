package com.apiobrasliterarias.repository;

import com.apiobrasliterarias.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBookRepository extends ElasticsearchRepository<Book,String> {
    @Override
    List<Book> findAll();

    List<Book> findAllByAuthorLike(String author);

    List<Book> findAllByTitleLike(String title);

    List<Book> findAllByPagesAfter(int cant_pages);

    List<Book> findAllByEditorialLike(String editorial);

    List<Book> findAllByPostAfter(LocalDate date);

    List<Book> findAllByPostBefore(LocalDate date);
}
