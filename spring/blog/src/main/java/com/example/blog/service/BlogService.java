package com.example.blog.service;

import com.example.blog.dto.request.BlogEntryRequestDTO;
import com.example.blog.dto.response.BlogEntryInfoDTO;
import com.example.blog.dto.response.CreateEntryResponseDTO;
import com.example.blog.exception.AlreadyExistException;
import com.example.blog.exception.NotFoundException;
import com.example.blog.model.BlogEntry;
import com.example.blog.repository.IBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {
    private final IBlogRepository repository;
    ModelMapper mapper = new ModelMapper();


    public BlogService(IBlogRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateEntryResponseDTO createEntry(BlogEntryRequestDTO entry) {
        if (repository.entryExist(entry)){
            throw new AlreadyExistException("Ya existe la entrada con el id " + entry.getId());
        } else {
            repository.createEntry(entry);
        }
        return new CreateEntryResponseDTO(entry.getId());
    }

    @Override
    public BlogEntryInfoDTO getEntry(int id) {
        BlogEntry entry = repository.getEntry(id)
                .orElseThrow(() -> new NotFoundException("No existe la entrada con id " + id));
        return mapper.map(entry, BlogEntryInfoDTO.class);
    }

    @Override
    public List<BlogEntryInfoDTO> getEntries() {
        return repository.getEntries().stream()
                .map(v -> mapper.map(v, BlogEntryInfoDTO.class))
                .collect(Collectors.toList());
    }
}
