package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.LiteratureDto;
import com.bootcamp.elastic.dto.request.DateDTO;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureService {

    List<LiteratureDto> findAll();

    List<LiteratureDto> saveAll(List<LiteratureDto> books);

    List<LiteratureDto> findAllByAuthor(String author);

    List<LiteratureDto> findAllByTitleContainsAny(List<String> words);

    List<LiteratureDto> findAllByCantPagesGreaterThan(Integer pages);

    List<LiteratureDto> findAllByFirstPostBefore(DateDTO dto);

    List<LiteratureDto> findAllByFirstPostAfter(DateDTO dto);

    List<LiteratureDto> findAllByEditorial(String editorial);
}
