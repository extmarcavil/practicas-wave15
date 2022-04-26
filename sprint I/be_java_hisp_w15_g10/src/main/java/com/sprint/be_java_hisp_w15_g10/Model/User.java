package com.sprint.be_java_hisp_w15_g10.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int user_id;
    private String user_name;
    private List<User> followers;
    private List<User> followed;
    private List<Post> posts;
}
