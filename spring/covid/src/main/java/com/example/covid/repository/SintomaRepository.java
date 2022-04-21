package com.example.covid.repository;

import com.example.covid.model.Sintoma;

import java.util.ArrayList;

public class SintomaRepository {
    private ArrayList<Sintoma> sintomaArrayList = new ArrayList<>();

    public SintomaRepository(){
        Sintoma s1 = new Sintoma("0","Fiebre",8);
        Sintoma s2 = new Sintoma("1","Dolor de Cabeza",5);
        Sintoma s3 = new Sintoma("2","Bajo nivel de saturacion",10);
        addSintoma(s1);
        addSintoma(s2);
        addSintoma(s3);
    }

    public void addSintoma(Sintoma sintoma){
        sintomaArrayList.add(sintoma);
    }

    public ArrayList<Sintoma> getSintomaArrayList() {
        return sintomaArrayList;
    }

    public Sintoma findByName(String name){
        return sintomaArrayList
                .stream()
                .filter(s->s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public Sintoma findById(String id){
        return sintomaArrayList
                .stream()
                .filter(s->s.getCode().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }
}
