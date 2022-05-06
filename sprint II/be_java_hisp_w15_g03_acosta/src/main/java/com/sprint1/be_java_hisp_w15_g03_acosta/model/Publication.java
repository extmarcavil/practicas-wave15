package com.sprint1.be_java_hisp_w15_g03_acosta.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {

    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private Category category;
    private Double price;
    private Product detail;
    private Boolean hasPromo;
    private Double discount;

    @Override
    public String toString() {
        return "Publication{" +
                "postId=" + postId +
                ", date=" + date +
                ", category=" + category +
                ", price=" + price +
                ", detail=" + detail +
                ", hasPromo=" + hasPromo +
                ", discount=" + discount +
                '}';
    }
}
