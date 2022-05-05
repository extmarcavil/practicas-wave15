package com.bootcamp.be_java_hisp_w15_g08.dto.response;

import com.bootcamp.be_java_hisp_w15_g08.dto.request.DetailDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostNotUserIdDTO {
    private int postID;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private DetailDTO detail;
    private Integer category;
    private double price;
}
