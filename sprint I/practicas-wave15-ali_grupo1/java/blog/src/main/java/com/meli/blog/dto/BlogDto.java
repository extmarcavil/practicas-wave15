package com.meli.blog.dto;

import com.meli.blog.model.Blog;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class BlogDto {

    private final String title;
    private final String authorName;
    private final LocalDate publicationDate;

    public static BlogDto from(Blog blog) {
        return new BlogDto(blog.getTitle(), blog.getAuthorName(), blog.getPublicationDate());
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
