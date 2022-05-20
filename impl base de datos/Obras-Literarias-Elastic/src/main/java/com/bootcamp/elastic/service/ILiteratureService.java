package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.dto.response.BookResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ILiteratureService {

    List<BookResponseDTO> getBooksByAutor(String autor);
    List<BookResponseDTO> getBooksWithWordsInTitle(String words);
    List<BookResponseDTO> getBooksByEditorial(String editorial);
    List<BookResponseDTO> getBooksWithPagesGreaterThan(Integer cantPages);
    List<BookResponseDTO> getBooksBefore(DateDTO date);
    List<BookResponseDTO> getBooksAfter(DateDTO date);
}
