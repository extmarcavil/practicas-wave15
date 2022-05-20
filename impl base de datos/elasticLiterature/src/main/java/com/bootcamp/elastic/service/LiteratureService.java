package com.bootcamp.elastic.service;

import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import com.bootcamp.elastic.request.DateDTO;
import com.bootcamp.elastic.request.LiteratureDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LiteratureService implements ILiteratureService{

    LiteratureRepository literatureRepository;

    public LiteratureService(LiteratureRepository literatureRepository) {
        this.literatureRepository = literatureRepository;
    }


    @Override
    public List<LiteratureDto> getBooks() {
        List<Literature> literatureList = literatureRepository.findAll();
        return getLiteratureDto(literatureList);
    }

    @Override
    public List<LiteratureDto> saveAllBooks(List<LiteratureDto> books) {
        List<Literature> literatureList = getLiterature(books);
        List<Literature> boocksSave = (List<Literature>) literatureRepository.saveAll(literatureList);
        return getLiteratureDto(boocksSave);
    }

    @Override
    public List<LiteratureDto> getBooksAuthor(String author) {
        List<Literature> literatureList = literatureRepository.findAllByAuthor(author);
        return getLiteratureDto(literatureList);
    }

    @Override
    public List<LiteratureDto> getBooksTitle(List<String> title) {
        List<Literature> literatureList = literatureRepository.findAllByTitleIn(title);
        return getLiteratureDto(literatureList);
    }

    @Override
    public List<LiteratureDto> getBooksMasCantPages(Integer cantPages) {
        List<Literature> literatureList = literatureRepository.findAllByCantPagesAfter(cantPages);
        return getLiteratureDto(literatureList);
    }

    @Override
    public List<LiteratureDto> getBooksDateAfter(DateDTO date) {
        List<Literature> literatureList = literatureRepository.findAllByFirstPostAfter(date.getDate());
        return getLiteratureDto(literatureList);
    }

    @Override
    public List<LiteratureDto> getBooksDateBefore(DateDTO date) {
        List<Literature> literatureList = literatureRepository.findAllByFirstPostBefore(date.getDate());
        return getLiteratureDto(literatureList);
    }

    @Override
    public List<LiteratureDto> getBooksEditorial(String editorial) {
        List<Literature> literatureList = literatureRepository.findAllByEditorial(editorial);
        return getLiteratureDto(literatureList);
    }

    private List<LiteratureDto> getLiteratureDto(List<Literature> literature){
        ModelMapper modelMapper = new ModelMapper();
        List<LiteratureDto> literatureDtoList = literature
                .stream()
                .map(l -> modelMapper.map(l, LiteratureDto.class))
                .collect(Collectors.toList());
        return literatureDtoList;
    }


    private List<Literature> getLiterature(List<LiteratureDto> literature){
        ModelMapper modelMapper = new ModelMapper();
        List<Literature> literatureList = literature
                .stream()
                .map(l -> modelMapper.map(l, Literature.class))
                .collect(Collectors.toList());
        return literatureList;
    }
}
