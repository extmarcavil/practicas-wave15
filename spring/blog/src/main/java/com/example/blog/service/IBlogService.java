package com.example.blog.service;

import com.example.blog.dto.request.BlogEntryRequestDTO;
import com.example.blog.dto.response.BlogEntryInfoDTO;
import com.example.blog.dto.response.CreateEntryResponseDTO;

import java.util.List;

public interface IBlogService {
    CreateEntryResponseDTO createEntry(BlogEntryRequestDTO entry);

    BlogEntryInfoDTO getEntry(int id);

    List<BlogEntryInfoDTO> getEntries();
}
