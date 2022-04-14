package com.company;

import com.company.Imprimibles.Curriculum;
import com.company.Imprimibles.Informes;
import com.company.Imprimibles.Librospdf;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> habilidades = new ArrayList<>();

        habilidades.add("diligente");
        habilidades.add("creativo");
        habilidades.add("proactivo");
        habilidades.add("colaborador");
        habilidades.add("dispuesto a aprender");

        Persona alejandro = new Persona("alejandro", "aguilar", "2342325", "Desarrollador de software", habilidades );


        Curriculum curriculum = new Curriculum(alejandro);

        Librospdf libro = new Librospdf("El asesino cotidiano",300, "Pedro Rivera", "Terror");

        String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin interdum at purus " +
                "nec venenatis. Duis vel dui velit. Aenean eu quam ut turpis ultrices convallis. Morbi a urna non odio " +
                "blandit vehicula. Mauris maximus ullamcorper erat. Cras cursus erat quis ex condimentum tempor. Nunc " +
                "faucibus nisi nunc, eget finibus metus euismod nec.\n" +
                "\n" +
                "Suspendisse dignissim bibendum arcu vitae dignissim. Suspendisse potenti." +
                " Nunc lobortis lectus nec nibh tincidunt, at laoreet lacus consequat. Mauris" +
                " fringilla vel augue eu finibus. Donec sagittis, ipsum nec interdum facilisis" +
                ", quam quam vestibulum leo, sed fermentum nibh purus ut orci. Donec tincidunt felis" +
                " at facilisis auctor. Curabitur ac diam efficitur, eleifend nulla sed, pretium odio." +
                " Aliquam venenatis ornare est, nec molestie nulla convallis a. Nam lobortis lacus sit " +
                "amet tempor lacinia. Integer suscipit ullamcorper accumsan. Maecenas imperdiet tellus volutpat" +
                " arcu bibendum, eu dapibus mauris fermentum. Interdum et malesuada fames ac ante ipsum primis in faucibus. " +
                "Nullam quis sapien at turpis finibus ornare posuere quis erat. Nunc ut velit mollis, accumsan nunc sit amet, hendrerit dolor.";

        Informes informes = new Informes(texto, 5, "Vicente Conde", "Don Revisor textual");

        informes.imprimir();
        curriculum.imprimir();
        libro.imprimir();

    }
}
