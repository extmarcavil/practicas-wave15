package com.bootcamp.be_java_hisp_w15_g08.dto.response;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.DetailDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PostNotUserIdDTO {
    private int postID;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private DetailDTO detail;
    private Integer category;
    private double price;
}
