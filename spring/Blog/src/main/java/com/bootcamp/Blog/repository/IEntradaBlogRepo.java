package com.bootcamp.Blog.repository;

import com.bootcamp.Blog.model.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepo {

    List<EntradaBlog> getAllBlogEntries();
    EntradaBlog getBlogEntryById(Integer id);
    void addBlogEntry(EntradaBlog eb);
}
