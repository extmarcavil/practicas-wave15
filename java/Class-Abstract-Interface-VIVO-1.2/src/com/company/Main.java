package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        /**
         * Instanciando los Documentos para imprimir.
         */
        Curriculum curriculum = new Curriculum("Pedro");
        Pdf pdf = new Pdf(10, 200, "Pedro", "Libroxx", "Suspenso");
        Informes informe = new Informes("hbdfbwd", 200, "Juan", "Pedro");


        /**
         * Imprimiendo cada Documento utilizando mi metodo por Default
         * de mi interfaz implementada en cada una de las clases.
         */
        curriculum.imprimirDocumento();

        informe.imprimirDocumento();

        pdf.imprimirDocumento();
    }
}
