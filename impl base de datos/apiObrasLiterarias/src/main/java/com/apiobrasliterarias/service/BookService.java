package com.apiobrasliterarias.service;

import com.apiobrasliterarias.domain.Book;
import com.apiobrasliterarias.dto.BookDTO;
import com.apiobrasliterarias.repository.IBookRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookService implements IBookService {
    private IBookRepository bookRepository;
    private ModelMapper mapper;

    public BookService(IBookRepository bookRepository, ModelMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    @Override
    public BookDTO newBook(BookDTO book) {
        Book newBook = bookRepository.save(mapper.map(book, Book.class));
        return mapper.map(newBook, BookDTO.class);
    }

    @Override
    public List<BookDTO> listBooksByAuthor(String author) {
        Type listType = new TypeToken<List<BookDTO>>(){}.getType();
        return mapper.map(bookRepository.findAllByAuthorLike(author),listType);
    }

    @Override
    public List<BookDTO> listBooksByTitle(String bookTitle) {
        Type listType = new TypeToken<List<BookDTO>>(){}.getType();
        return mapper.map(bookRepository.findAllByTitleLike(bookTitle),listType);
    }

    @Override
    public List<BookDTO> listBooksAfterCantPages(int cant_pages) {
        Type listType = new TypeToken<List<BookDTO>>(){}.getType();
        return mapper.map(bookRepository.findAllByPagesAfter(cant_pages),listType);
    }

    @Override
    public List<BookDTO> listBooksByEditorial(String editorial) {
        Type listType = new TypeToken<List<BookDTO>>(){}.getType();
        return mapper.map(bookRepository.findAllByEditorialLike(editorial),listType);
    }

    @Override
    public boolean addBooks(List<BookDTO> books) {
        Type listType = new TypeToken<List<Book>>(){}.getType();
        bookRepository.saveAll(mapper.map(books,listType));
        return true;
    }

    @Override
    public List<BookDTO> listBooksByAfterYear(int year) {
        Type listType = new TypeToken<List<BookDTO>>(){}.getType();
        var date = LocalDate.parse(year + "-01-01");
        return mapper.map(bookRepository.findAllByPostAfter(date),listType);
    }

    @Override
    public List<BookDTO> listBooksByBeforeYear(int year) {
        Type listType = new TypeToken<List<BookDTO>>(){}.getType();
        var date = LocalDate.parse(year + "-01-01");
        return mapper.map(bookRepository.findAllByPostBefore(date),listType);
    }
}
