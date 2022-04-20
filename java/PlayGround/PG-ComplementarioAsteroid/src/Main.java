import model.JuegoAsteroid;
import model.NaveEspacial;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<Point> listaDeMeteoritos = new ArrayList<Point>(Arrays.asList(
                new Point(4,3),
                new Point(-1,5),
                new Point(1,2),
                new Point(0,7),
                new Point(-5,2),
                new Point(5,-5)
                ));

        JuegoAsteroid juegoNuevo = new JuegoAsteroid(listaDeMeteoritos);


        NaveEspacial halconMilenario = new NaveEspacial("Halcon Milenario",0,0);
        NaveEspacial estrellaDeLaMuerte = new NaveEspacial("Estrella de la muerte",5,5);
        NaveEspacial razorCrest = new NaveEspacial(" Razor Crest",2,2);
        NaveEspacial battlestarGaláctica = new NaveEspacial("Battlestar Galáctica",-1,-2);
        NaveEspacial slave1 = new NaveEspacial("Slave 1 - Firespray",-3,7);


        juegoNuevo.inscribirParticipante("Jim",estrellaDeLaMuerte);
        juegoNuevo.inscribirParticipante("Michael",Arrays.asList(halconMilenario,razorCrest,slave1));
        juegoNuevo.inscribirParticipante("Dwight",battlestarGaláctica);

        juegoNuevo.computarGanador();


        juegoNuevo.imprimirTablaDePosiciones();

    }
}
