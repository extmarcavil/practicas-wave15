package ar.com.alehenestroza.apiconcesionariaautos.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CarMechanicalService {
    private LocalDate   date;
    private Integer     kilometers;
    private String      descriptions;
}
