package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;

import java.time.LocalDate;
import java.util.List;

public interface ILiteratureService {
    List<LiteratureDTO> saveAll(List<LiteratureDTO> literatureList);
    void deleteAll();
    List<LiteratureDTO> findAll();
    List<LiteratureDTO> findAllByAuthor(String author);
    List<LiteratureDTO> findAllByTitleIn(List<String> words);
    List<LiteratureDTO> findAllByCantPagesGreaterThan(Integer amount);
    List<LiteratureDTO> findAllByFirstPostBefore(LocalDate date);
    List<LiteratureDTO> findAllByFirstPostAfter(LocalDate date);
    List<LiteratureDTO> findAllByEditorial(String editorial);
}
