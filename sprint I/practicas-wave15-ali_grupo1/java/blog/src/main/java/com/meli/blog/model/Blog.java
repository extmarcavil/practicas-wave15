package com.meli.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
public class Blog {

    private final Long id;
    private final String title;
    private final String authorName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate publicationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return Objects.equals(id, blog.id) && Objects.equals(title, blog.title)
                && Objects.equals(authorName, blog.authorName)
                && Objects.equals(publicationDate, blog.publicationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authorName, publicationDate);
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }

}
