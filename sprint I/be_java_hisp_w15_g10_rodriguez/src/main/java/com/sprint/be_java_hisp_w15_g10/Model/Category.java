package com.sprint.be_java_hisp_w15_g10.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category implements IIdInterface {
    private int category_id;
    private String category_name;

    @Override
    public int getId() {
        return category_id;
    }

    @Override
    public <T> boolean compares(T field) {
        return category_name.equals(field);
    }

    @Override
    public void setId(int id) {
        category_id = id;
    }
}
