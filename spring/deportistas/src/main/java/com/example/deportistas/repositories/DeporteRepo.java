package com.example.deportistas.repositories;

import com.example.deportistas.model.Deporte;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DeporteRepo {
    List<Deporte> deporteList;
    public DeporteRepo(){
        deporteList = new ArrayList<>(List.of(
                                            new Deporte("Futbol", "Medio"),
                                            new Deporte("Natacion", "Dificl"),
                                            new Deporte("Tenis", "Medio"),
                                            new Deporte("Boxeo", "Dificl")
                                    ));
    }

    public void addDeporte(Deporte d) {
        deporteList.add(d);
    }

    public void addAll(List<Deporte> deportes) {
        deporteList.addAll(deportes);
    }
}
