package com.santiagopinzondev.Covid19;

import java.util.ArrayList;
import java.util.List;

public class Sintomas {
    private static List<Sintoma> sintomas = new ArrayList<>();

    @Override
    public String toString() {
        return "Sintomas{" +
                "sintomas=" + sintomas +
                '}';
    }

    public void addSintoma(Sintoma sintoma){
        sintomas.add(sintoma);
    }
    public static List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }
}
