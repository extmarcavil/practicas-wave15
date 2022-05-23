package com.meli.elasticsearch.repository;

import com.meli.elasticsearch.domain.LiteraryWork;

import java.time.LocalDate;
import java.util.List;

public interface LiteraryWorkRepository extends GenericElasticsearchRepository<LiteraryWork> {

    List<LiteraryWork> findAllByAuthor(String author);

    List<LiteraryWork> findAllByNameContainsIgnoreCase(String name);

    List<LiteraryWork> findAllByNumberOfPagesGreaterThan(Integer numberOfPages);

    List<LiteraryWork> findAllByYearOfPublicationBefore(LocalDate yearOfPublication);

    List<LiteraryWork> findAllByYearOfPublicationAfter(LocalDate yearOfPublication);

    List<LiteraryWork> findAllByEditorial(String editorial);
}
