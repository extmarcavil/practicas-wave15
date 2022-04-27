package com.bootcamp.be_java_hisp_w15_g08.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailDTO {
    private int  product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}


