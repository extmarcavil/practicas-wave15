package com.apiconcesionarioautos.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ServiceResponseDTO {
    private Date date;
    private double kilometers;
    private String descriptions;

    public ServiceResponseDTO() {
    }

    public ServiceResponseDTO(Date date, double kilometers, String descriptions) {
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }
}
