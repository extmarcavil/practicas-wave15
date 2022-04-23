package com.example.blog.repository;

import com.example.blog.model.BlogEntry;
import com.example.blog.dto.request.BlogEntryRequestDTO;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {

    void createEntry(BlogEntryRequestDTO entry);

    boolean entryExist(BlogEntryRequestDTO entry);

    Optional<BlogEntry> getEntry(int id);

    List<BlogEntry> getEntries();
}
