package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> skills = new ArrayList<>();
        skills.add("Aprendizaje autonomo");
        Curriculum curr = new Curriculum("Edwin",27,skills);
        curr.imprimir();
    }
}
