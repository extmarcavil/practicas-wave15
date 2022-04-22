package com.apiconcesionarioautos.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ServiceRequestDTO {
    private Date date;
    private double kilometers;
    private String descriptions;

    public ServiceRequestDTO() {
    }

    public ServiceRequestDTO(Date date, double kilometers, String descriptions) {
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }
}
