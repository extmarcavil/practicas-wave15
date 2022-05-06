package com.be.java.hisp.w156.be.java.hisp.w156.dto.response;

import com.be.java.hisp.w156.be.java.hisp.w156.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ResponsePostDTO {

    private Integer post_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product detail;
    private String category;
    private Double price;

    public static ResponsePostDTO from(Post post) {
        return new ResponsePostDTO(post.getPost_id(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice());
    }

    @Override
    public String toString() {
        return "ResponsePostDTO{" +
                "post_id=" + post_id +
                ", date=" + date +
                ", detail=" + detail +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
