package com.meli.blog.dto;

import com.meli.blog.model.Blog;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
@Getter
public class SuccessDto {

    private final Long id;
    private final String message;
    private final Instant createdAt;

    public static SuccessDto from(Blog blog) {
        String message = String.format("Blog with title [%s] was created successfully", blog.getTitle());
        return new SuccessDto(blog.getId(), message, Instant.now());
    }

    @Override
    public String toString() {
        return "SuccessDto{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
