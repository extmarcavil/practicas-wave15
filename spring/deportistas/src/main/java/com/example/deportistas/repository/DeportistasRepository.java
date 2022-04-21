package com.example.deportistas.repository;

import java.util.ArrayList;
import java.util.HashMap;

public class DeportistasRepository {
    private HashMap<String, ArrayList<String>> deportistas = new HashMap<>();

    public DeportistasRepository(){
        ArrayList<String> primero = new ArrayList<String>();
        primero.add("0");
        ArrayList<String> segundo = new ArrayList<String>();
        segundo.add("0");
        segundo.add("1");

        deportistas.put("0",primero);
        deportistas.put("1",segundo);
    }

    public HashMap<String, ArrayList<String>> getDeportistas() {
        return deportistas;
    }
}
