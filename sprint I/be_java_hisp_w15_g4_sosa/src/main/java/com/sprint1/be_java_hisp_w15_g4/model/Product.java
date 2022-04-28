package com.sprint1.be_java_hisp_w15_g4.model;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Setter
@Getter
public class Product {
    private static AtomicInteger idSequence = new AtomicInteger();
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
    public Product(){
        this.product_id = idSequence.incrementAndGet();
    }
}
