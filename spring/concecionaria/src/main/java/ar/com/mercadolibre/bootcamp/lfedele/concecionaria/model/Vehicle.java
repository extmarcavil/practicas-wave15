package ar.com.mercadolibre.bootcamp.lfedele.concecionaria.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Vehicle {
    private static Long nextId = 1L;

    private Long id;
    private String brand;
    private String model;
    private LocalDate fabricationDate;
    private Integer price;

    private String datoSecretoDelBackend;

    public Vehicle() {
        this.id = nextId;
        nextId++;
    }

    public Vehicle(String brand, String model, LocalDate fabricationDate, Integer price) {
        this.id = nextId;
        nextId++;
        this.brand = brand;
        this.model = model;
        this.fabricationDate = fabricationDate;
        this.price = price;

        this.datoSecretoDelBackend = "BOTON DE AUTODESTRUCCION INCLUIDO";
    }

    public void setId(Long id) {
    }
}
