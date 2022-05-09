package com.sprint.be_java_hisp_w15_g10.Model;

import lombok.*;

@Getter
@AllArgsConstructor
public class Category {
    private int category_id;
    private String category_name;

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
