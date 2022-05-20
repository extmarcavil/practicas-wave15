package com.bootcamp.elastic.service;

import com.bootcamp.elastic.request.DateDTO;
import com.bootcamp.elastic.request.LiteratureDto;

import java.util.List;

public interface ILiteratureService {

    List<LiteratureDto> getBooks();

    List<LiteratureDto> saveAllBooks(List<LiteratureDto> books);

    List<LiteratureDto> getBooksAuthor(String author);
    List<LiteratureDto> getBooksTitle(List<String> title);

    List<LiteratureDto> getBooksMasCantPages(Integer cantPages);

    List<LiteratureDto> getBooksDateAfter(DateDTO date);

    List<LiteratureDto> getBooksDateBefore(DateDTO date);

    List<LiteratureDto> getBooksEditorial(String editorial);
}
