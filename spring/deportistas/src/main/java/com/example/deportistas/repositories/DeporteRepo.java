package com.example.deportistas.repositories;

import com.example.deportistas.model.Deporte;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class DeporteRepo implements IDeporteRepo{
    List<Deporte> deporteList;
    public DeporteRepo(){
        deporteList = new ArrayList<>(List.of(
                                            new Deporte("Futbol", "Medio"),
                                            new Deporte("Natacion", "Dificl"),
                                            new Deporte("Tenis", "Medio"),
                                            new Deporte("Boxeo", "Dificl")
                                    ));
    }

    @Override
    public void addDeporte(Deporte d) {
        deporteList.add(d);
    }

    @Override
    public void addAll(List<Deporte> deportes) {
        deporteList.addAll(deportes);
    }

    @Override
    public List<Deporte> getDeporteList(){return deporteList;}
}
