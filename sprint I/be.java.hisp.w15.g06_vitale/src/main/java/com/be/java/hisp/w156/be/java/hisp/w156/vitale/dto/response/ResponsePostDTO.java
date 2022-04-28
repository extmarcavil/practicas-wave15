package com.be.java.hisp.w156.be.java.hisp.w156.vitale.dto.response;

import com.be.java.hisp.w156.be.java.hisp.w156.vitale.model.Post;
import com.be.java.hisp.w156.be.java.hisp.w156.vitale.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponsePostDTO {

    private Integer post_id;
    private String date;
    private Product detail;
    private String category;
    private Double price;

    public static ResponsePostDTO from(Post post) {
        String date = LocalDate.from(post.getDate()).toString();
        return new ResponsePostDTO(post.getPost_id(), date, post.getDetail(), post.getCategory(), post.getPrice());
    }
}
