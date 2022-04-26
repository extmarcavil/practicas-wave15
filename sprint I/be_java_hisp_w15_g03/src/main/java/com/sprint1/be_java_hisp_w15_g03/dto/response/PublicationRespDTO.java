package com.sprint1.be_java_hisp_w15_g03.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint1.be_java_hisp_w15_g03.dto.ProductDTO;
import com.sprint1.be_java_hisp_w15_g03.model.Category;
import com.sprint1.be_java_hisp_w15_g03.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * para "posts:" de US:06
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationRespDTO {

    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private Integer category;
    private Double price;
    private ProductDTO detail;

}
