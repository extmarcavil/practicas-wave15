package com.sprint.be_java_hisp_w15_g10.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private Product detail;
    private LocalDate date;
    private Category category;
    private double price;
    private boolean has_promo;
    private double discount;
}
