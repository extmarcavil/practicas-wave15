package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.LiteratureDTO;

import java.util.List;

public interface LiteratureService {
    List<LiteratureDTO> getAll(String author, String title, Integer minPages, Integer minYear, Integer maxYear, String byPublisher);
    boolean saveAll(List<LiteratureDTO> books);
    boolean deleteAll();
}
