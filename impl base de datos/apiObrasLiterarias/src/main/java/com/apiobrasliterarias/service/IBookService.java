package com.apiobrasliterarias.service;

import com.apiobrasliterarias.dto.BookDTO;

import java.util.List;

public interface IBookService {
    BookDTO newBook(BookDTO book);

    boolean  addBooks(List<BookDTO> books);

    List<BookDTO> listBooksByAuthor(String author);

    List<BookDTO> listBooksByTitle(String bookTitle);

    List<BookDTO> listBooksAfterCantPages(int cant_pages);

    List<BookDTO> listBooksByEditorial(String editorial);

    List<BookDTO> listBooksByAfterYear(int year);

    List<BookDTO> listBooksByBeforeYear(int year);
}
