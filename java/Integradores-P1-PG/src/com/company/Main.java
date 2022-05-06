package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        // 1.
        /**
         * Creando una serie de 2. type Double
         */
        Prototipo protDouble = new Prototipo1();

        //Creando la serie de 2.
        protDouble.setSerie(2.0);

        //Resultado de la serie progresiva.
        protDouble.valorSigueinteSerie();
        protDouble.valorSigueinteSerie();
        protDouble.valorSigueinteSerie();
        protDouble.valorSigueinteSerie();

        System.out.println("Estableciendo el valor inicial de la serie en 1.0"+ "\n");
        protDouble.establecerValorIncialSerie(1.0);

        protDouble.valorSigueinteSerie();
        protDouble.valorSigueinteSerie();
        protDouble.valorSigueinteSerie();
        protDouble.valorSigueinteSerie();

        protDouble.Reiniciar();
        System.out.println("Reiniciando el valor inicial de la serie en: 0 "+ "\n");

        protDouble.valorSigueinteSerie();
        protDouble.valorSigueinteSerie();
        protDouble.valorSigueinteSerie();
        protDouble.valorSigueinteSerie();

        System.out.println("Empezando con la serie de 3"+ "\n");
        /**
         * Creando una serie de 3 Type Integer
         */
        Prototipo protInt = new Prototipo2();

        //Creando la Serie de 3
        protInt.setSerie(3);

        //Estableciendo el valor inicial de la serie.
        //protInt.establecerValorIncialSerie(1);

        //Resultado de la serie progresiva.
        protInt.valorSigueinteSerie();
        protInt.valorSigueinteSerie();
        protInt.valorSigueinteSerie();
        protInt.valorSigueinteSerie();

        protInt.Reiniciar();
        System.out.println("Reiniciando el valor incial de la serie: 0 "+ "\n");

        protInt.valorSigueinteSerie();
        protInt.valorSigueinteSerie();
        protInt.valorSigueinteSerie();
        protInt.valorSigueinteSerie();


    }
}
