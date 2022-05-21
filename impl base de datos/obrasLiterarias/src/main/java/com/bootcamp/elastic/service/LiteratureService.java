package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.request.LiteratureDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LiteratureService implements ILiteratureService {

    private LiteratureRepository literatureRepository;
    private ModelMapper mapper;

    public LiteratureService(LiteratureRepository literatureRepository, ModelMapper mapper) {
        this.literatureRepository = literatureRepository;
        this.mapper = mapper;
    }

    @Override
    public List<LiteratureDTO> findAll() {
        return map(literatureRepository.findAll());
    }

    public List<LiteratureDTO> saveAll(List<LiteratureDTO> books) {

        List<Literature> list = books.stream().map(l -> mapper.map(l, Literature.class))
                .collect(Collectors.toList());

        //StreamSupport convierte de iterable a list
        return map(StreamSupport.stream(
                literatureRepository.saveAll(list).spliterator(), false)
                .collect(Collectors.toList()));
    }

    @Override
    public void deleteAll() {
        literatureRepository.deleteAll();
    }

    @Override
    public List<LiteratureDTO> findAllByAuthor(String author) {
        return map(literatureRepository.findAllByAuthor(author));
    }

    @Override
    public List<LiteratureDTO> findAllByTitle(List<String> list) {
        return map(literatureRepository.findAllByTitleIn(list));
    }

    @Override
    public List<LiteratureDTO> getBooksGreaterThanCantPages(Integer cantPages) {
        return map(literatureRepository.findAllByCantPagesGreaterThan(cantPages));
    }

    @Override
    public List<LiteratureDTO> getBooksBeforeDate(DateDTO date) {
        return map(literatureRepository.findAllByFirstPostBefore(date.getDate()));
    }

    @Override
    public List<LiteratureDTO> getBooksAfterDate(DateDTO date) {
        return map(literatureRepository.findAllByFirstPostAfter(date.getDate()));
    }

    @Override
    public List<LiteratureDTO> getBooksByEditorial(String editorial) {
        return map(literatureRepository.findAllByEditorial(editorial));
    }

    private List<LiteratureDTO> map(List<Literature> list){
        return list
                .stream()
                .map(l -> mapper.map(l, LiteratureDTO.class))
                .collect(Collectors.toList());
    }
}
