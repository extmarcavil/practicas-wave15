package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.request.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;

import java.util.List;

public interface ILiteratureService {
    List<LiteratureDTO> findAll();

    List<LiteratureDTO> saveAll(List<LiteratureDTO> books);

    void deleteAll();

    List<LiteratureDTO> findAllByAuthor(String author);

    List<LiteratureDTO> findAllByTitle(List<String> list);

    List<LiteratureDTO> getBooksGreaterThanCantPages(Integer cantPages);

    List<LiteratureDTO> getBooksBeforeDate(DateDTO date);

    List<LiteratureDTO> getBooksAfterDate(DateDTO date);

    List<LiteratureDTO> getBooksByEditorial(String editorial);
}
