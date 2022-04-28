package com.example.be_java_hisp_w15_g05.dto;

import com.example.be_java_hisp_w15_g05.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResListPostPromoDTO {
     private int user_id;
     private String user_name;
     private List<Post>  posts;
}
