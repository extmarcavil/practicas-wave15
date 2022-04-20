import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(1000,500,"Dakar",3);

        carrera.darDeAltaAuto(150,100,30,"AA123CF");
        carrera.darDeAltaAuto(250,90,38,"AA456HL");
        carrera.darDeAltaMoto(125,70,30,"AD654EE");


        carrera.socorrerAuto("AA456HL");
        carrera.socorrerAuto("AD654EE");
        carrera.socorrerMoto("AD654EE");
        carrera.socorrerMoto("AA123CF");
    }
}
