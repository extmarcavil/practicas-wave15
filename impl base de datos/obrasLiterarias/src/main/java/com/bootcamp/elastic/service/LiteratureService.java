package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.request.LiteratureDTO;

import java.util.List;

public interface LiteratureService {
    List<LiteratureDTO> getAll();
    List<LiteratureDTO> saveAll(List<LiteratureDTO> respLiteratureDTO);
    void deleteAll();
    List<LiteratureDTO>  findAllByAuthorLike(String author);
    List<LiteratureDTO> findAllByTitleIn(List<String> words);
    List<LiteratureDTO>  findAllByCantPagesGreaterThan(Integer cantPages);
    List<LiteratureDTO> findAllByFirstPostBefore(DateDTO date);
    List<LiteratureDTO>  findAllByFirstPostAfter(DateDTO date);
    List<LiteratureDTO>  findAllByEditorialLike(String editorial);
}
