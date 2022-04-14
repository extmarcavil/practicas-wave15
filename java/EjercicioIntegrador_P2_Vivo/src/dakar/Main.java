package dakar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Carrera carrera = new Carrera(100,2000,"Dakar",3);

        carrera.darDeAltaAuto(200,80,38,"Badboys");
        carrera.darDeAltaAuto(250,90,38,"Homer");
        carrera.darDeAltaMoto(125,70,30,"abc123");


        carrera.socorrerAuto("abc123");
    }
}
