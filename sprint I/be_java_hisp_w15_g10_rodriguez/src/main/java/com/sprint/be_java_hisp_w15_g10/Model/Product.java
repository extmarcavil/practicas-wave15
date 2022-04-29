package com.sprint.be_java_hisp_w15_g10.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements IIdInterface {
    private int product_id;

    @Override
    public String toString() {
        return product_name + type + brand + color + notes;
    }

    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    @Override
    public int getId() {
        return product_id;
    }

    @Override
    public <T> boolean compares(T field) {
        return toString().equals(field);
    }

    @Override
    public void setId(int id) {
        product_id = id;
    }
}
