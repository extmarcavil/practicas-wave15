package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.response.BookResponseDTO;
import com.bootcamp.elastic.repository.LiteratureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LiteratureService implements ILiteratureService{

    LiteratureRepository literatureRepository;

    public LiteratureService(LiteratureRepository literatureRepository)
    {
        this.literatureRepository = literatureRepository;
    }

    public List<BookResponseDTO> getBooksByAutor(String autor)
    {
        ModelMapper mapper = new ModelMapper();

        return literatureRepository.findAllByAuthor(autor).stream()
                .map(m -> mapper.map(m,BookResponseDTO.class))
                .collect(Collectors.toList());

    }

    public List<BookResponseDTO> getBooksByEditorial(String editorial)
    {
        ModelMapper mapper = new ModelMapper();

        return literatureRepository.findAllByEditorial(editorial).stream()
                .map(m -> mapper.map(m,BookResponseDTO.class))
                .collect(Collectors.toList());

    }

    public List<BookResponseDTO> getBooksWithWordsInTitle(String words)
    {
        ModelMapper mapper = new ModelMapper();
        return literatureRepository.findAllByTitleContaining(words)
                .stream()
                .map(m -> mapper.map(m,BookResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List<BookResponseDTO> getBooksWithPagesGreaterThan(Integer cantPages){
        ModelMapper mapper = new ModelMapper();
        return literatureRepository.findAllByCantPagesGreaterThan(cantPages)
                .stream()
                .map(m -> mapper.map(m,BookResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List<BookResponseDTO> getBooksBefore(DateDTO date){
        ModelMapper mapper = new ModelMapper();
        return literatureRepository.findAllByFirstPostBefore(date.getDate())
                .stream()
                .map(m -> mapper.map(m,BookResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List<BookResponseDTO> getBooksAfter(DateDTO date){
        ModelMapper mapper = new ModelMapper();
        return literatureRepository.findAllByFirstPostAfter(date.getDate())
                .stream()
                .map(m -> mapper.map(m,BookResponseDTO.class))
                .collect(Collectors.toList());
    }
}
