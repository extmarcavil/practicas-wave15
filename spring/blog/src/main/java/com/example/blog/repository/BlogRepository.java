package com.example.blog.repository;

import com.example.blog.model.BlogEntry;
import com.example.blog.dto.request.BlogEntryRequestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository implements IBlogRepository {

    private List<BlogEntry> entries;
    ModelMapper mapper = new ModelMapper();


    public BlogRepository() {
        this.entries = new ArrayList<>();
    }

    @Override
    public void createEntry(BlogEntryRequestDTO entry) {
        entries.add(mapper.map(entry, BlogEntry.class));
    }

    public boolean entryExist(BlogEntryRequestDTO entry) {
        return entries.stream().anyMatch(v -> v.getId() == entry.getId());
    }

    @Override
    public Optional<BlogEntry> getEntry(int id) {
        return entries.stream()
                .filter(v -> v.getId() == id)
                .findFirst();
    }

    @Override
    public List<BlogEntry> getEntries() {
        return entries;
    }
}
