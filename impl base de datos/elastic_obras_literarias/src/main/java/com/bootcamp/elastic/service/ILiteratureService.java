package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;

import java.time.LocalDate;
import java.util.List;

public interface ILiteratureService {
    List<Literature> getBooks();

    List<Literature> getBooksByAuthor(String author);

    List<Literature> saveAllBooks(List<Literature> books);

    List<Literature> getBooksByTitle(List<String> titleWords);

    List<Literature> getBooksWithPagesGreaterThan(Integer pages);

    List<Literature> getBooksBeforeYear(DateDTO date);

    List<Literature> getBooksAfterYear(DateDTO date);

    List<Literature> getBooksByEditorial(String editorial);
}
