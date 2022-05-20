package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.TitleFilterDTO;
import com.bootcamp.elastic.dto.response.LiteratureDTO;

import java.time.LocalDate;
import java.util.List;

public interface ILiteratureService {
    List<LiteratureDTO> findByAuthor(String author);

    List<LiteratureDTO> findByFilter(TitleFilterDTO titleFilterDTO);

    List<LiteratureDTO> findByPagesGreaterThan(Integer pages);

    List<LiteratureDTO> findBeforeDate(LocalDate date);

    List<LiteratureDTO> findAfterDate(LocalDate date);

    List<LiteratureDTO> findByEditorial(String editorial);
}
