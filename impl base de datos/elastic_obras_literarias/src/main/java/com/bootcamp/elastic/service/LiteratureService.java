package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteratureService implements ILiteratureService{
    private final LiteratureRepository repository;
    private final ModelMapper mapper;

    public LiteratureService(LiteratureRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Retornar todas las obras.
     *
     * @return List<Literature>: Lista de obras.
     */
    @Override
    public List<Literature> getBooks() {
        return repository.findAll();
    }

    /**
     * Retornar las obras de un autor dado por el usuario.
     *
     * @param author String: Palabra para buscar por autor.
     * @return List<Literature>: Lista de obras del autor.
     */
    @Override
    public List<Literature> getBooksByAuthor(String author) {
        return repository.findAllByAuthorLike(author);
    }


    /**
     * Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
     *
     * @param titleWords List<String>: Palabras para buscar en el título.
     * @return List<Literature>: Lista de obras con esas palabras.
     */
    @Override
    public List<Literature> getBooksByTitle(List<String> titleWords) {
        return repository.findAllByTitleIn(titleWords);
    }

    /**
     * Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
     *
     * @param pages Integer: Cantidad de páginas.
     * @return List<Literature>: Lista de obras con más cantidad de páginas que la indicada.
     */
    @Override
    public List<Literature> getBooksWithPagesGreaterThan(Integer pages) {
        return repository.findAllByCantPagesGreaterThan(pages);
    }

    /**
     * Retornar las obras que fueron publicadas antes de un año dado por el usuario.
     *
     * @param dateDTO DateDTO
     * @return List<Literature>
     */
    @Override
    public List<Literature> getBooksBeforeYear(DateDTO dateDTO) {
        return repository.findAllByFirstPostBefore(dateDTO.getDate());
    }

    /**
     * Retornar las obras que fueron publicadas después de un año dado por el usuario.
     *
     * @param dateDTO DateDTO
     * @return List<Literature>
     */
    @Override
    public List<Literature> getBooksAfterYear(DateDTO dateDTO) {
        return repository.findAllByFirstPostAfter(dateDTO.getDate());
    }

    /**
     * Retornar las obras de una misma editorial.
     *
     * @param editorial String
     * @return List<Literature>
     */
    @Override
    public List<Literature> getBooksByEditorial(String editorial) {
        return repository.findAllByEditorial(editorial);
    }

    /**
     * Guardar una lista de obras
     *
     * @param books List<Literature>: Lista de obras a guardar.
     * @return List<Literature>: Lista de obras guardadas.
     */
    @Override
    public List<Literature> saveAllBooks(List<Literature> books) {
        return (List<Literature>) repository.saveAll(books);
    }
}
